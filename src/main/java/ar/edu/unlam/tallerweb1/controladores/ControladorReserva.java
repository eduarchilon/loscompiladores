package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorReserva {


    private static ServicioReserva servicioReserva;
    private static ClienteService servicioCliente;
    private static MesaService mesaServicio;
    private static RestauranteService restauranteService;
    @Autowired
    public ControladorReserva(ServicioReserva servicioReserva,MesaService mesaServicio,RestauranteService restauranteService,ClienteService servicioCliente) {
        this.servicioReserva = servicioReserva;
        this.servicioCliente = servicioCliente;
        this.mesaServicio = mesaServicio;
        this.restauranteService = restauranteService;
    }




    @RequestMapping(path = "todasLasReservas",method = {RequestMethod.GET})
    public ModelAndView getTodasLasReservas() {
        ModelMap modelo = new ModelMap();
        List<Reserva> listaReserva = servicioReserva.buscoTodasLasReservas();
        modelo.put("reservas",listaReserva);
        return new ModelAndView("todasLasReservas",modelo);

    }

    @RequestMapping(method = RequestMethod.GET, value ="misReservas")
    public ModelAndView getTodasLasReservasDeUnUsuario(@RequestParam(value = "idCiente", required = false)Long idCiente) {
        ModelMap modelo = new ModelMap();
        Cliente cliente = servicioCliente.verClientePorId(idCiente);
        System.out.println(cliente.getId());
        List<Reserva> listaReserva = servicioReserva.buscoTodasLasReservasClientes(cliente);
        modelo.put("reservas",listaReserva);
        modelo.put("clienteId",idCiente);
        return new ModelAndView("misReservas",modelo);

    }
    @RequestMapping(value = "misReservas/{reservaId}/{clienteId}",method = {RequestMethod.POST,RequestMethod.GET})
    public static ModelAndView eliminarReserva(@PathVariable("reservaId") Long reservaId,@PathVariable("clienteId") Long clienteId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelMap modelo = new ModelMap();
        Boolean eliminado = servicioReserva.eliminarReserva(reservaId);
        System.out.println(eliminado);
        return new ModelAndView("redirect:/misReservas").addObject("idCiente",clienteId);
    }
    @RequestMapping(value = "misReservas/{reservaId}/{clienteId}",method = {RequestMethod.GET})
    public static ModelAndView eliminarRedirectReserva(@PathVariable Long reservaId ,@PathVariable("clienteId") Long clienteId) throws IOException {

        return new ModelAndView("redirect:/misReservas").addObject("idCiente",clienteId);

    }

    @RequestMapping(value = "crear-reserva/red/{clienteId}/{mesaId}/{fechaDate}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView creaUnaReserva(@PathVariable Long clienteId, @PathVariable Long mesaId,@PathVariable String fechaDate) {
        ModelMap model = new ModelMap();
        Date fecha = null;
        try {
            String inputDate = fechaDate.replace("T", " ");
            fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inputDate);
        } catch (ParseException e) {
            System.out.println("error Fecha");
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        System.out.println(fecha);
        Mesa mesa = mesaServicio.getMesaPorId(mesaId);
        Cliente cliente = servicioCliente.verClientePorId(clienteId);
        Reserva reserva = new Reserva(cliente,mesa,calendar);

        servicioReserva.creoUnaReserva(reserva);
        return new ModelAndView("redirect:/misReservas").addObject("idCiente",clienteId);

    }
    @RequestMapping(value = "crear-reserva/{clienteId}/{mesaId}/{date}",method = {RequestMethod.GET})
    public static ModelAndView creaUnaReservaRedirect(@PathVariable Long clienteId, @PathVariable Long mesaId,@PathVariable String fechaDate){


        return new ModelAndView("redirect:/misReservas").addObject("idCiente",clienteId);

    }
    @RequestMapping(value = "crear-reserva/{idResto}",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView creoUnFormularioDeReservaBuscar(@PathVariable long idResto) {
        ModelMap modelo = new ModelMap();

        Restaurante resto = restauranteService.buscarRestaurantePorId(idResto);

        modelo.put("restaurante",resto);
        return new ModelAndView("crear-reserva",modelo);
    }
    @RequestMapping(value = "crear-reserva/{idResto}/{date}",method = {RequestMethod.POST,RequestMethod.GET})

    public ModelAndView creoUnFormularioDeReserva(@PathVariable Long idResto, @PathVariable String date) {

        ModelMap modelo = new ModelMap();
        Date fecha = null;
        try {
            String inputDate = date.replace("T", " ");
            fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inputDate);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        System.out.println(fecha);

        Restaurante resto = restauranteService.buscarRestaurantePorId(idResto);
        List<Mesa> mesas = servicioReserva.buscaMesasDisponiblesSegunHorario(resto,cal);
        modelo.put("fecha",date);
        modelo.put("mesas",mesas);
        modelo.put("restaurante",resto);
        return new ModelAndView("crear-reserva",modelo);
    }


}

