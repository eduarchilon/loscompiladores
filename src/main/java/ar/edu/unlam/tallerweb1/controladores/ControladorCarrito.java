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
import java.util.List;

@Controller
public class ControladorCarrito {

    private CarritoService carritoService;

    @Autowired
    public ControladorCarrito(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView verCarritoModal(HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        /*Hardcodeado ya que no hay login*/
        Carrito carrito =(Carrito) carritoService.verPlatosDelCarrito(1L);
        List<Carrito> platosCarrito = (List<Carrito>) carritoService.verListDePlatosDelCarrito();
        System.out.println("/**********************/");
        System.out.println(platosCarrito);
        System.out.println("/**********************/");
        modelo.put("platosCarrito", platosCarrito);
        modelo.put("carritoModal", carrito);
        return new ModelAndView("carrito", modelo);
    }

}
