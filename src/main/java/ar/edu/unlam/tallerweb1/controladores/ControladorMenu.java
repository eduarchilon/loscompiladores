package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorMenu {

    private RestauranteService restauranteService;

    @Autowired
    public ControladorMenu(RestauranteService restauranteService){
        this.restauranteService = restauranteService;
    }

    @RequestMapping(path = "/platos-del-restaurante/{idRestaurante}", method = RequestMethod.GET)
    public ModelAndView verCartaDelRestaurante(@PathVariable("idRestaurante") Long idRestaurante){
       ModelMap modelo = new ModelMap();
        Restaurante resto = (Restaurante) restauranteService.buscarRestaurantePorId(idRestaurante);
        modelo.put("resto", resto);
        List<Plato> platosRestaurantes = (List<Plato>) restauranteService.verPlatosDelRestaurante(idRestaurante);
        modelo.put("platosRestaurante", platosRestaurantes);
        return new ModelAndView("menu-restaurante", modelo);
        }


}
