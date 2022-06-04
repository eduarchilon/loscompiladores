package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.controladores.ControladorBusqueda;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.forms.FormBuscarPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBusquedaTest {

    public static final String VISTA_BUSQUEDA = "buscar-plato";
    public static final String NOMBRE_VALIDO = "Empanada";
    public static final String NOMBRE_INVALIDO = "Silla";

    private ControladorBusqueda controladorBusqueda;
    private ServicioBusqueda servicioBusqueda;


    @Before
    public void init(){
        servicioBusqueda = mock(ServicioBusqueda.class);
        controladorBusqueda = new ControladorBusqueda(servicioBusqueda);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElNombreBuscado(){
        dadoQueExisteUnPlatoConNombre(NOMBRE_VALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConNombre(NOMBRE_VALIDO);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoBuscado(){
        dadoQueNoExisteUnPlatoConNombre(NOMBRE_INVALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConNombre(NOMBRE_INVALIDO);

        entoncesRegresoALaVistaBusquedaConMensajeError("Nombre de comida incorrecto, intenta de nuevo! :)", mav);

    }



    private void dadoQueExisteUnPlatoConNombre(String nombrePlato) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombrePlato)).thenReturn(platos);
    }

    private void dadoQueNoExisteUnPlatoConNombre(String nombrePlato) {
        when(servicioBusqueda.buscar(nombrePlato)).thenReturn(new LinkedList());
    }


    private ModelAndView cuandoBuscoUnPlatoConNombre(String nombrePlato) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato(nombrePlato);
        form.setLocalidadRestaurante("");
        return controladorBusqueda.buscar(form);
    }


    private void entoncesRegresoALaVistaBusquedaConPlatos(String nombreVista, ModelAndView mav) {
        List <Plato> platos = (List<Plato>) mav.getModel().get("platos");
        assertThat(mav.getViewName()).isEqualTo(nombreVista);
        assertThat(mav.getModel().get("platos")).isEqualTo(platos);
    }

    private void entoncesRegresoALaVistaBusquedaConMensajeError(String error, ModelAndView mav) {
    assertThat(mav.getViewName()).isEqualTo("buscar-plato");
    assertThat(mav.getModel().get("error")).isEqualTo(error);
    }






}
