package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorMesasTest {

    private static final String VISTA_MESA = "mesas";
    private ControladorMesa controladorMesa;
    private MesaService mesaService;
    private RestauranteService restauranteService;

    @Before
    public void init(){
        mesaService = mock(MesaService.class);
        restauranteService = mock(RestauranteService.class);
        controladorMesa= new ControladorMesa(mesaService, restauranteService);
    }

    @Test
    public void queMuestreLosMesasDelResto() {

        dadoQueExistanPlatosMasvendidos(5);

        ModelAndView mav = cuandoLasMesasDelResto();

        entoncesEncuentro(mav, 5);

        entoncesMeLLevaALaVista(VISTA_MESA, mav.getViewName());
    }

    private void entoncesMeLLevaALaVista(String vistaMesa, String viewName) {
        assertThat(vistaMesa).isEqualTo(viewName);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidadEsperada) {
        List<Mesa> lista = (List<Mesa>) mav.getModel().get("listMesas");
        assertThat(lista).hasSize(cantidadEsperada);
    }

    private ModelAndView cuandoLasMesasDelResto() {
        return controladorMesa.verMesas(1L);
    }

    private void dadoQueExistanPlatosMasvendidos(int cantidad) {
        List<Mesa> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Mesa());
        }
        Restaurante resto = new Restaurante(1L, "resto");
        when(mesaService.getMesasDelRestaurante(resto.getId())).thenReturn(lista);
    }
}
