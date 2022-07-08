package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorMesa {

    private MesaService mesaService;
    private RestauranteService restauranteService;

    @Autowired
    public ControladorMesa(MesaService mesaService, RestauranteService restauranteService){
        this.mesaService= mesaService;
        this.restauranteService= restauranteService;
    }

    @RequestMapping(path = "/{idResto}/mesas", method = RequestMethod.GET)
    public ModelAndView verMesas(@PathVariable("idResto")  Long idResto){
        ModelMap modelo = new ModelMap();
        Restaurante resto = (Restaurante) restauranteService.buscarRestaurantePorId(idResto);
        modelo.put("resto", resto);
        modelo.put("listMesas", (List<Mesa>) mesaService.getMesasDelRestaurante(idResto));
        return new ModelAndView("mesas", modelo);
    }
}
