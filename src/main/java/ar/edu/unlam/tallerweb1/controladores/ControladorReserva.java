package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ControladorReserva {


    private static ServicioReserva servicioReserva;
    @Autowired
    public ControladorReserva(ServicioReserva servicioReserva) {
        this.servicioReserva = servicioReserva;
    }




    @RequestMapping(path = "todasLasReservas",method = {RequestMethod.GET})
    public ModelAndView getTodasLasReservas() {
        ModelMap modelo = new ModelMap();
        List<Reserva> listaReserva = servicioReserva.buscoTodasLasReservas();
        modelo.put("reservas",listaReserva);
        return new ModelAndView("todasLasReservas",modelo);

    }
    @RequestMapping(value = "todasLasReservas/{reservaId}",method = {RequestMethod.POST,RequestMethod.GET})
    public static ModelAndView eliminarReserva(@PathVariable("reservaId") Long reservaId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelMap modelo = new ModelMap();
        Boolean eliminado = servicioReserva.eliminarReserva(reservaId);
        System.out.println(eliminado);
        return new ModelAndView("redirect:/todasLasReservas",modelo);
    }
    @RequestMapping(value = "todasLasReservas/{reservaId}",method = {RequestMethod.GET})
    public static ModelAndView eliminarRedirectReserva(@PathVariable Long reservaId ) throws IOException {

        return new ModelAndView("redirect:/todasLasReservas");
    }
//@RequestMapping(value = "todasLasReservas/{idReserva}", method ={ RequestMethod.POST, RequestMethod.GET })
//public ModelAndView borrarReservaDeLaLista(@PathVariable("idReserva")  Long idRserva, HttpServletResponse response, HttpServletRequest request) throws IOException {
//    ModelMap modelo = new ModelMap();
//
//    Boolean borrado = servicioReserva.eliminarReserva(idRserva);
//    modelo.put("operacion",borrado);
//    return new ModelAndView("elemento-eliminado", modelo);
//}
//
////    @RequestMapping(value = "todasLasReservas/{idReserva}", method = RequestMethod.GET)
////    public ModelAndView redirectReserva(@PathVariable Long idReserva) throws IOException {
////        return new ModelAndView("redirect:/todasLasReservas");
////    }
}
