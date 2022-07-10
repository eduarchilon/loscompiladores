package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorRestaurante {

    private ServicioBusqueda servicioBusqueda;

    private ClienteService clienteService;

    private PedidoService pedidoService;

    private RestauranteService restauranteService;

    private LocalidadService localidadService;

    @Autowired
    public ControladorRestaurante(ServicioBusqueda servicioBusqueda, ClienteService clienteService, PedidoService pedidoService, RestauranteService restauranteService, LocalidadService localidadService){
        this.servicioBusqueda = servicioBusqueda;
        this.clienteService=clienteService;
        this.pedidoService = pedidoService;
        this.restauranteService = restauranteService;
        this.localidadService=localidadService;
    }

    @RequestMapping(path = "/carta-personalizada", method = RequestMethod.GET)
    public ModelAndView cartaPersonalizada(){
        ModelMap modelo = new ModelMap();
        List<Plato> platos = servicioBusqueda.listaPlatosMasVendidos();
        List<Plato> carta = new ArrayList<>();
        try{
            for (int i = 0; i < 3 ; i++) {
                carta.add(platos.get(i));
            }
        }catch (Exception e){
            modelo.put("msj", "error");
        }
        modelo.put("platos", carta);
        return new ModelAndView("cartaPersonalizada", modelo);
    }

    @RequestMapping(path = "/ver-clientes", method = RequestMethod.GET)
    public ModelAndView verClientes(){
        ModelMap modelo = new ModelMap();
        List<Cliente> clientes = clienteService.verClientes();
        modelo.put("clientes", clientes);
        return new ModelAndView("clientes", modelo);
    }

    @RequestMapping(path = "/ver-pedido-cliente/{nombre}", method = RequestMethod.GET)
    public ModelAndView verPedidosDeClientes(@PathVariable("nombre") String nombre){
        ModelMap modelo = new ModelMap();
        Cliente buscado = clienteService.obtenerClientePorNombre(nombre);
        modelo.put("buscado", buscado);
        List<Pedido> pedidos = pedidoService.verPedidosClientes(buscado);
        HashSet<Pedido> pedidosBuscados = new HashSet<>();
        for (int i = 0; i < pedidos.size(); i++) {
            pedidosBuscados.add(pedidos.get(i));
        }
        modelo.put("pedidos", pedidosBuscados);
        return new ModelAndView("clientes", modelo);
    }

    @RequestMapping(path = "/ver-pedido-cliente/{nombre}/ver-platos-del-pedido/{pedido}", method = RequestMethod.GET)
    public ModelAndView verPlatosDelPedido(@PathVariable("pedido")  Long pedido){
        ModelMap modelo = new ModelMap();
        Pedido pedidoBuscado = (Pedido)pedidoService.buscarPedidoPorId(pedido);
        modelo.put("pedidoBuscado", pedidoBuscado);
        modelo.put("listaPlatos", (List<Plato>) pedidoBuscado.getListPlatos());
        return new ModelAndView("pedidos-clientes", modelo);
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView verRestaurantesMasValorados(){
        ModelMap modelo = new ModelMap();
        List<Restaurante> valorados = (List<Restaurante>) restauranteService.getRestaurantesMasCalificados();
        modelo.put("restosValorados", valorados);
        return new ModelAndView("home", modelo);
    }


    @RequestMapping(path = "/restaurantes", method ={ RequestMethod.GET, RequestMethod.POST})
    public ModelAndView verTodosLosRestaurantes(){
        ModelMap modelo = new ModelMap();
        List<Localidad> localidades = (List<Localidad>)localidadService.verLocalidades();
        List<Restaurante> lista = (List<Restaurante>) restauranteService.verTodosLosRestaurantes();
        modelo.put("localidades", localidades);
        modelo.put("restaurantes", lista);
        return new ModelAndView("restaurantes", modelo);
    }

    @RequestMapping(path = "/restaurantes/{idLocalidad}", method = RequestMethod.GET)
    public ModelAndView verTodosLosRestaurantes(@PathVariable("idLocalidad")  Long idLocalidad) {
        ModelMap modelo = new ModelMap();
        List<Localidad> localidades = (List<Localidad>)localidadService.verLocalidades();
        List<Restaurante> restaurantes = (List<Restaurante>) restauranteService.buscarPorLocalidad(idLocalidad);
        modelo.put("localidades", localidades);
        modelo.put("restaurantes", restaurantes);
        return new ModelAndView("por-localidad", modelo);
    }

}
