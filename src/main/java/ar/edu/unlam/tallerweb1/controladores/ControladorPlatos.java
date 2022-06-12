package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPlatos {

    @Autowired
    public PlatoService platoService;

    @Autowired
    public ControladorPlatos(PlatoService platoService){
        this.platoService = platoService;
    }

    @RequestMapping(path = "/lista-platos", method = RequestMethod.GET)
    public ModelAndView irAlistaDePlatos(){
        ModelMap modelo = new ModelMap();
        modelo.put("plato", platoService.verPlatos());
        return new ModelAndView("platos", modelo);
    }

    @RequestMapping(path = "/cantidad-de-platos", method = RequestMethod.GET)
    public ModelAndView iAlaCantidadDePlatos(){
        ModelMap modelo = new ModelMap();
        modelo.put("cantidadPlatos", platoService.verCantidadDePlatos());
        return new ModelAndView("platos", modelo);
    }



}
