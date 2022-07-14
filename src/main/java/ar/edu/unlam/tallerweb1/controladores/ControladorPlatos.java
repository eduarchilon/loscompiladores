package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorPlatos {


    public PlatoService platoService;
    private ServicioAdicional servicioAdicional;

    @Autowired
    public ControladorPlatos(PlatoService platoService, ServicioAdicional servicioAdicional){
        this.platoService = platoService;
        this.servicioAdicional = servicioAdicional;
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
        modelo.put("cantidadPlatos", platoService.verPlatos().size());
        return new ModelAndView("platos", modelo);
    }

    @RequestMapping(path = "/ver-plato/{idPlato}", method = RequestMethod.GET)
    public ModelAndView verPlatoEnVistya(@PathVariable("idPlato") Long idPlato){
        ModelMap modelo = new ModelMap();
        Plato plato = (Plato)platoService.buscarPlato(idPlato);
        List<Adicional> listaAdicionales = (List<Adicional>) servicioAdicional.getAdicionalesPorGusto(plato.getTipo());
        Double precioConAdicionales = plato.getPrecio();
        modelo.put("adicionales", listaAdicionales);
        modelo.put("platoBuscado", plato);
        for (int i = 0; i < listaAdicionales.size(); i++) {
            precioConAdicionales += listaAdicionales.get(i).getPrecio();
        }
        modelo.put("PrecioFinal", precioConAdicionales);
        return new ModelAndView("vista-plato", modelo);
    }


}
