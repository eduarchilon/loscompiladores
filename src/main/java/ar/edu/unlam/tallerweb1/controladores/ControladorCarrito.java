package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ControladorCarrito {

    private CarritoService carritoService;

    @Autowired
    public ControladorCarrito(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @RequestMapping(path = "/cart", method = { RequestMethod.GET })
    @ResponseBody
    public ModelAndView verCarritoModal(HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        List<Carrito> platosCarrito = (List<Carrito>) carritoService.verListDePlatosDelCarrito();
        modelo.put("platosCarrito", platosCarrito);
        return new ModelAndView("carrito", modelo);
    }

    @RequestMapping(value = "cart/{idCart}", method = RequestMethod.POST)
    public ModelAndView borrarPlatoModall(@PathVariable("idCart")  Long idCart, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelMap modelo = new ModelMap();
        Boolean resultado = carritoService.borrarPlatoDelCarrito(idCart);
        String mensaje = "Borrado";
        modelo.put("mensajeDel", mensaje);
        return new ModelAndView("redirect:/cart", modelo);
    }

    @RequestMapping(value = "cart/{idCart}", method = RequestMethod.GET)
    public ModelAndView redirect(@PathVariable Long idCart) throws IOException {

        return new ModelAndView("redirect:/cart");
    }

}
