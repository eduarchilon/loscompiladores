package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorReservaTest {
    private ServicioReserva servicioReserva;
    private ControladorReserva controladorReserva;
    HttpServletRequest request;
    HttpServletResponse response;

    @Before
    public void init(){
        servicioReserva= mock(ServicioReserva.class);
        controladorReserva = new ControladorReserva(servicioReserva);
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

    private ModelAndView cuandoBorroUnaReserva(Long reservaId, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        List<Reserva> listaEncontradas = muestra.getModel().get("reservas");
        return controladorReserva.borrarReservaDeLaLista(reservaId,response,request);
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
