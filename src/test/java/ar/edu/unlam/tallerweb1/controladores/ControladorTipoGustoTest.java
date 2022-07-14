package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoGusto;
import org.springframework.web.servlet.ModelAndView;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorTipoGustoTest {

    private ServicioTipoGusto servicioTipoGusto;
    private PlatoService servicioPlato;
    private ControladorTipoGusto controladorTipoGusto;
    private static final String VISTA_TIPO = "todosLosPlatos";
    private static final String VISTA_PLATOS_TIPO = "platosPorGusto";

    @Before
    public void init(){
        servicioTipoGusto = mock(ServicioTipoGusto.class);
        servicioPlato = mock(PlatoService.class);
        controladorTipoGusto = new ControladorTipoGusto(servicioTipoGusto,servicioPlato);
    }

    @Test
    public void mustrarTipoDeGustos(){
        dadoQueExistenTipoDeGustos(2);
        ModelAndView muestraGustos = cuandoQuieroVerTodosLosGustos();
        entoncesEncuentro(muestraGustos, 2);
        entoncesMeLlevaALaVista(VISTA_TIPO, muestraGustos.getViewName());
    }

    @Test
    public void mustrarTodosLosPlatos(){
        dadoQueExistenPlatos(2);
        ModelAndView muestraPlatos = cuandoQuieroVerTodosLosPlatos();
        entoncesEncuentro(muestraPlatos, 2);
        entoncesMeLlevaALaVista(VISTA_TIPO, muestraPlatos.getViewName());
    }

    @Test
    public void mostrarLosPlatosPorGusto(){
        dadoQueExistenPlatos(2);
        ModelAndView muestraPlatos = cuandoQuieroVerLosPlatosPorGusto();
        entoncesEncuentro(muestraPlatos, 2);
        entoncesMeLlevaALaVista(VISTA_PLATOS_TIPO, muestraPlatos.getViewName());

    }

    private ModelAndView cuandoQuieroVerLosPlatosPorGusto() {
        TipoGusto tipoGusto = new TipoGusto(1L, "tailandes");
        return controladorTipoGusto.verPlatosPorGusto(tipoGusto.getId());
    }


    private ModelAndView cuandoQuieroVerTodosLosPlatos() {
        return controladorTipoGusto.verTodosLosTipoDeGustos();
    }

    private void dadoQueExistenPlatos(int i) {
        List<Plato> listaPlatos = new LinkedList();
        for (int j = 0; j < i; j++) {
            listaPlatos.add(new Plato());
        }
        when(servicioPlato.verPlatos()).thenReturn(listaPlatos);
    }


    private void entoncesMeLlevaALaVista(String todosLosPlatos, String viewName) {
        assertThat(todosLosPlatos).isEqualTo(viewName);
    }

    private void entoncesEncuentro(ModelAndView muestraGustos, int i) {
        List<TipoGusto> listaEncontrada = (List<TipoGusto>)muestraGustos.getModel().get("tipoGusto");
    }

    private ModelAndView cuandoQuieroVerTodosLosGustos() {
        return controladorTipoGusto.verTodosLosTipoDeGustos();
    }

    private void dadoQueExistenTipoDeGustos(int i) {
        List<TipoGusto> listaGustos = new LinkedList();
        for (int j = 0; j < i; j++) {
            listaGustos.add(new TipoGusto());
        }
        when(servicioTipoGusto.verTodosLosGustos()).thenReturn(listaGustos);
        //mockeamos 2 gustos en el servicio tipoGustos
    }


}
