package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.servicios.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ControladorCupon {


    private CuponService cuponService;

    @Autowired
    public ControladorCupon(CuponService cuponService) {
        this.cuponService = cuponService;
    }

    @RequestMapping(value = "/aplicar-cupon/{cupon}", method = {RequestMethod.GET})
    public ModelAndView aplicarCupon(@PathVariable("cupon") String nombreCupon) {
        ModelMap modelo = new ModelMap();
        Cupon cuponBuscado = cuponService.obetenerCupon(nombreCupon);
        Double descuento = cuponService.canjearCuponEnPorcentaje(cuponBuscado);
            String mensaje = "Cupon aplicado con exito.";
            modelo.put("cuponDescuento", descuento);
            modelo.put("cuponAplicado", cuponBuscado);
            modelo.put("mensajeCupon", mensaje);
        return new ModelAndView("carrito", modelo);
    }

    @RequestMapping(value = "/aplicar-cupon/{cupon}", method = {RequestMethod.GET})
    public ModelAndView redirecto(@PathVariable String nombreCupon) throws IOException {
        return new ModelAndView("redirect:/cart");
    }
}
