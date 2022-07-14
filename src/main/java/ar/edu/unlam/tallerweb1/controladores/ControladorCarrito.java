package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.CarritoAdicional;
import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.CarritoService;
import ar.edu.unlam.tallerweb1.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ControladorCarrito {

    private CarritoService carritoService;
    private CuponService cuponService;

    @Autowired
    public ControladorCarrito(CarritoService carritoService, CuponService cuponService) {
        this.carritoService = carritoService;
        this.cuponService = cuponService;
    }

    @RequestMapping(path = "/cart", method = { RequestMethod.GET })
    @ResponseBody
    public ModelAndView verCarritoModal(@RequestParam(value ="searchString", required = false)String pSearchTerm, HttpServletRequest request, HttpServletResponse response)throws IOException {
        ModelMap modelo = new ModelMap();
        List<Carrito> platosCarrito = (List<Carrito>) carritoService.verListDePlatosDelCarrito();
        List<CarritoAdicional> adicionalesCarrito = (List<CarritoAdicional>) carritoService.verListDeAdicionalesDelCarrito();
        modelo.put("adicionalesCarrito", adicionalesCarrito);


        modelo.put("searchTerm", pSearchTerm);
        Cupon cupon = cuponService.obetenerCupon(pSearchTerm);
        modelo.put("cupon", cupon);

        Double subtotal = (Double)carritoService.getSubtotal(platosCarrito) + (Double)carritoService.getSubtotalAdicionales(adicionalesCarrito);
        modelo.put("subtotal", subtotal);
        modelo.put("platosCarrito", platosCarrito);
        return new ModelAndView("carrito", modelo);
    }

    @RequestMapping(value = "cart/{idCart}", method = RequestMethod.POST)
    public ModelAndView borrarPlatoModall(@PathVariable("idCart")  Long idCart, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelMap modelo = new ModelMap();
        Boolean resultado = carritoService.borrarPlatoDelCarrito(idCart);
        return new ModelAndView("redirect:/cart", modelo);
    }

    @RequestMapping(value = "cart/{idCart}", method = RequestMethod.GET)
    public ModelAndView redirect(@PathVariable Long idCart) throws IOException {
        return new ModelAndView("redirect:/cart");
    }

    @RequestMapping(value = "/agregar-plato/{plato}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView alumnosSinCurso(@PathVariable("plato") Long plato) {
        ModelMap modelo = new ModelMap();
        carritoService.agregarPlatoAlCarrito(plato);
        return new ModelAndView("redirect:/cart", modelo);
    }

    @RequestMapping(value = "/agregar-adicional/{idAdicional}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView agregarAdicional(@PathVariable("idAdicional") Long idAdicional) {
        ModelMap modelo = new ModelMap();
        carritoService.agregarAdicionalAlCarrito(idAdicional);
        return new ModelAndView("redirect:/cart", modelo);
    }

    @RequestMapping(value = "borrar-adicional/{idAdicionalCarrito}", method = RequestMethod.POST)
    public ModelAndView borrarAdicionalModall(@PathVariable("idAdicionalCarrito")  Long idAdicionalCarrito, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelMap modelo = new ModelMap();
        Boolean resultado = carritoService.borrarAdicionalDelCarrito(idAdicionalCarrito);
        return new ModelAndView("redirect:/cart", modelo);
    }


//    @RequestMapping(value="/cart/{searchString}")
//    public ModelAndView Search(@RequestParam(value ="searchString", required = false) String pSearchTerm, HttpServletRequest request, HttpServletResponse response) {
//        return new ModelAndView("redirect:/cart");
//    }
}
