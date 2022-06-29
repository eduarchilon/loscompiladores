package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.forms.FormBuscarPlato;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioDetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorPedidos {

    private PedidoService servicioPedido;
    private ServicioDetallePedido servicioDetallePedido;

    @Autowired
    public ControladorPedidos(PedidoService servicioPedido, ServicioDetallePedido servicioDetallePedido){
        this.servicioPedido = servicioPedido;
        this.servicioDetallePedido = servicioDetallePedido;
    }

    @RequestMapping(path = "/pedidos-clientes", method = RequestMethod.GET)
    public ModelAndView verTodosLosPedidos(){
        ModelMap modelo = new ModelMap();
        return null;
    }

    @RequestMapping(path = "agregar-plato", method = RequestMethod.POST)
        public ModelAndView agregarPlatoAlDetallePedido(@ModelAttribute("formBuscarPlato") FormBuscarPlato plato, HttpServletRequest request){
        ModelMap model = new ModelMap();

       servicioDetallePedido.agregarPlatoAlDetallePedido(request);
       model.put("isAgregado", "Su comida se ha agregado correctamente al pedido");

        return new ModelAndView("buscarPlato", model);
    }

    @RequestMapping(path = "mostrar-pedido")
    public ModelAndView mostrarDetallePedido(@ModelAttribute("formBuscarPlato") FormBuscarPlato plato, HttpServletRequest request){
        ModelMap model = new ModelMap();
        List<DetallePedido> listaDetalle;
        if(request.getParameter("nombrePlatoElegido")!=null) {

            servicioDetallePedido.eliminarPlatoDelDetallePedido(request);
            listaDetalle = servicioDetallePedido.buscarPorIdCliente(request);
            System.out.println("elimina");
            model.put("pedido", listaDetalle);

        }else{

            listaDetalle = servicioDetallePedido.buscarPorIdCliente(request);

            for (DetallePedido algo:listaDetalle) {
                System.out.println(algo.getId_detallePlato());
            }
            model.put("pedido", listaDetalle);

        }
        return new ModelAndView("buscarPlato", model);


    }


    @RequestMapping(path = "realizar-pedido", method = RequestMethod.POST)
    public ModelAndView realizarPedido(HttpServletRequest request){
        ModelMap model = new ModelMap();
        List<DetallePedido> listaDetalle;
        servicioPedido.realizarPedido(request);

        listaDetalle = servicioDetallePedido.buscarPorIdCliente(request);
        model.put("pedido", listaDetalle);

        return new ModelAndView("pedido", model);
    }

    @RequestMapping(path = "cancelar-pedido", method = RequestMethod.POST)
    public ModelAndView cancelarPedido(HttpServletRequest request){
        return new ModelAndView("pedido");
    }

    @RequestMapping(path = "eliminar-plato")
    public ModelAndView eliminarPlatoAlDetallePedido(@ModelAttribute("formBuscarPlato") FormBuscarPlato plato, HttpServletRequest request){
        ModelMap model = new ModelMap();
        List<DetallePedido> listaDetalle;

        servicioDetallePedido.eliminarPlatoDelDetallePedido(request);
        listaDetalle = servicioDetallePedido.buscarPorIdCliente(request);
        model.put("pedido", listaDetalle);

        return new ModelAndView("buscarPlato", model);
    }


}
