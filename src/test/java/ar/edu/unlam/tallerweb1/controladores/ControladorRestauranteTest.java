package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorRestauranteTest {


    private static final String VISTA_CARTA = "cartaPersonalizada";
    private ControladorRestaurante controladorRestaurante;
    private ServicioBusqueda servicioBusqueda;


    @Before
    public void init(){
        servicioBusqueda = mock(ServicioBusqueda.class);
        controladorRestaurante = new ControladorRestaurante(servicioBusqueda);

    }

    @Test
    public void queTraigaTresPlatosParalaCartaDelGustoDelCliente(){

        dadoQueExistanPlatosMasvendidos(10);

        ModelAndView mav = cuandoBuscoPlatosMasVendidos();

        entoncesEncuentro(mav, 3);

        entoncesMeLLevaALaVista(VISTA_CARTA, mav.getViewName());


    }

    private void entoncesMeLLevaALaVista(String vistaRecibida, String vistaEsperada) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidadEsperada) {

        List<Plato> lista = (List<Plato>) mav.getModel().get("platos");
        assertThat(lista).hasSize(cantidadEsperada);
    }

    private ModelAndView cuandoBuscoPlatosMasVendidos() {
        return controladorRestaurante.cartaPersonalizada();
    }

    private void dadoQueExistanPlatosMasvendidos(int cantidad) {
        List<Plato> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Plato());
        }
        when(servicioBusqueda.listaPlatosMasVendidos()).thenReturn(lista);
    }
}
