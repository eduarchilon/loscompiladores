package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoGusto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorTipoGusto {

    private ServicioTipoGusto servicioTipoGusto;
    private PlatoService servicioPlato;

    @Autowired
    public ControladorTipoGusto(ServicioTipoGusto servicioTipoGusto, PlatoService servicioPlato) {
        this.servicioTipoGusto = servicioTipoGusto;
        this.servicioPlato = servicioPlato;
    }

    @RequestMapping(path = "ver-platos")
    public ModelAndView verTodosLosTipoDeGustos() {
        ModelMap modelo = new ModelMap();
        List<TipoGusto> listaGustos = servicioTipoGusto.verTodosLosGustos();
        List<Plato> listaPlatos = servicioPlato.verPlatos();
        modelo.put("tipoGusto", listaGustos);
        modelo.put("platos", listaPlatos);
        return new ModelAndView("todosLosPlatos", modelo);

    }

    @RequestMapping(path = "ver-platos/{idGusto}", method = RequestMethod.GET)
    public ModelAndView verPlatosPorGusto(@PathVariable("idGusto") Long idGusto) {
        ModelMap modelo = new ModelMap();
        List<TipoGusto> listaGustos = servicioTipoGusto.verTodosLosGustos();
        List<Plato> listaPlatos = servicioTipoGusto.verPlatosPorGusto(idGusto);
        modelo.put("tipoGusto", listaGustos);
        modelo.put("platos", listaPlatos);
        return new ModelAndView("platosPorGusto", modelo);
    }
}
