package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorReserva {


    private ServicioReserva servicioReserva;
    @Autowired
    public ControladorReserva(ServicioReserva servicioReserva) {
        this.servicioReserva = servicioReserva;
    }


    @RequestMapping(path = "todasLasReservas")
    public ModelAndView getTodasLasReservas() {
        ModelMap modelo = new ModelMap();
        List<Reserva> listaReserva = servicioReserva.buscoTodasLasReservas();
        modelo.put("reservas",listaReserva);
        return new ModelAndView("todasLasReservas",modelo);

    }
}
