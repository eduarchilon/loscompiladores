package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorReservaTest {
    private ServicioReserva servicioReserva;
    private ControladorReserva controladorReserva;

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
