package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorRestaurante {

    private ServicioBusqueda servicioBusqueda;


    @Autowired
    public ControladorRestaurante(ServicioBusqueda servicioBusqueda){
        this.servicioBusqueda = servicioBusqueda;
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

}