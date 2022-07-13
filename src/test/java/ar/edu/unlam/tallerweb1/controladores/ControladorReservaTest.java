package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorReservaTest {
    private ServicioReserva servicioReserva;
    private RestauranteService servicioRestaurante;
    private MesaService servicioMesa;
    private ControladorReserva controladorReserva;
    HttpServletRequest request;
    HttpServletResponse response;
    Cliente cliente = new Cliente(1L);
    Restaurante resto = new Restaurante(1L,9,23);
    Calendar date = new GregorianCalendar(2023,12,12,12,00);
    private Mesa mesa1 = new Mesa(1L,resto,1,4);

    @Before
    public void init(){
        servicioReserva= mock(ServicioReserva.class);
        servicioRestaurante = mock(RestauranteService.class);
        servicioMesa = mock(MesaService.class);
        controladorReserva = new ControladorReserva(servicioReserva,servicioMesa,servicioRestaurante);

    }
    @Test
    public void muestrarReservas(){
        dadoQueExistenReservas(3);
        ModelAndView muestra = cuandoQuieroVerTodasLasReservas();
        entoncesEncuentro(muestra,3);
        entoncesMeLLevaALaVista("todasLasReservas",muestra.getViewName());
    }
    @Test
    public void eliminarReservasEnElControlador() throws IOException {
        dadoQueExistenReservas(3);
        Reserva reserva = new Reserva(1L);
        ModelAndView muestra = cuandoBorroUnaReserva(1L,response,request);
        entoncesEncuentro(muestra,2);
        entoncesMeLLevaALaVista("redirect:/todasLasReservas",muestra.getViewName());
    }
    @Test
    public void formularioCrearReserva() throws IOException {
        dadoQueExistaUnRestaurante(1L);
        dadoQueExistaUnRestauranteConMesas(1L,3);
        ModelAndView muestra = cuandocreoUnFormularioDeReserva(1L);
//todo: arreglar este test para poder terminar el controlador previo terminar el todo del servicio
        entoncesMeLLevaALaVista("crear-reserva",muestra.getViewName());
    }

    private void dadoQueExistaUnRestaurante(Long i) {

        when(servicioRestaurante.buscarRestaurantePorId(i)).thenReturn(new Restaurante());
    }
    private void dadoQueExistaUnRestauranteConMesas(long l, int i) {
        List<Mesa> mesaList = new LinkedList<Mesa>();
        for (int j = 0; j < i; j++) {
            mesaList.add(new Mesa());
        }
        when(servicioMesa.getMesasDelRestaurante(l)).thenReturn(mesaList);
    }

    private ModelAndView cuandocreoUnFormularioDeReserva(long l) {
        return controladorReserva.creoUnFormularioDeReserva(l);
    }

    @Test
    public void crearReserva(){
        dadoQueExistenReservas(3);
//        Reserva reserva = new Reserva(cliente,mesa1,date);
//        Long Long = 0L;
//        when(servicioReserva.creoUnaReserva(reserva)).thenReturn(Long);
        ModelAndView muestra = cuandoCreoUnaReserva(cliente,mesa1,date);
        entoncesEncuentro(muestra,4);
        entoncesMeLLevaALaVista("redirect:/home",muestra.getViewName());
    }

    private ModelAndView cuandoCreoUnaReserva(Cliente cliente, Mesa mesa1, Calendar date) {
        return controladorReserva.creaUnaReserva(cliente.getId(),mesa1.getId(),date);
    }

    private ModelAndView cuandoBorroUnaReserva(Long reservaId, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        List<Reserva> listaEncontradas = muestra.getModel().get("reservas");
        return controladorReserva.eliminarReserva(reservaId,response,request);
    }

    private void entoncesMeLLevaALaVista(String todasLasReservas, String viewName) {
        assertThat(todasLasReservas).isEqualTo(viewName);
    }

    private void entoncesEncuentro(ModelAndView muestra, int i) {
        List<Reserva> listasEncontradas = (List<Reserva>) muestra.getModel().get("reservas");
    }

    private ModelAndView cuandoQuieroVerTodasLasReservas() {
        return controladorReserva.getTodasLasReservas();
    }

    private void dadoQueExistenReservas(int i) {
        List<Reserva> reservaList = new LinkedList<Reserva>();
        for (int j = 0; j < i; j++) {
            reservaList.add(new Reserva());
        }
        when(servicioReserva.buscoTodasLasReservas()).thenReturn(reservaList);
        //me crea 3 reservas
    }


}
