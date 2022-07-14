package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;

import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioAdicional;
import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorPlatosTest{

   private ControladorPlatos controladorPlatos;
   private PlatoService servicioPlato;
   private ServicioAdicional servicioAdicional;
   private TipoGusto vegetariano;
    private Plato plato1;
    private Plato plato2;
    private List<Plato> listaPlatos;
    private static final String VISTA_PLATOS = "vista-plato";

    @Before
    public void init(){
        //creo una instancia falsa de la implementacion
        servicioAdicional = mock(ServicioAdicional.class);
        servicioPlato = mock(PlatoService.class);
        controladorPlatos = new ControladorPlatos(servicioPlato, servicioAdicional);
        listaPlatos = new LinkedList();

    }

    @Test
    public void queMuestreTodosLosPlatosConSusAdicionales(){
        dadoQueExistenPlatosConAdicionales();
        ModelAndView muestraPlatos = cuandoQuieroVerLosPlatos(plato1.getId());
        entonesEncuentro(muestraPlatos,2);
        entoncesMeLlevaALaVista(VISTA_PLATOS, muestraPlatos.getViewName());

    }

    private void entoncesMeLlevaALaVista(String vistaPlatos, String viewName) {
        assertThat(vistaPlatos).isEqualTo(viewName);
    }

    private void entonesEncuentro(ModelAndView muestraPlatos, int i) {
        List<Adicional> listaEncontrada = (List<Adicional>)muestraPlatos.getModel().get("adicionales");
    }

    private ModelAndView cuandoQuieroVerLosPlatos(Long idPlato) {
        when(servicioPlato.buscarPlato(idPlato)).thenReturn(plato1);
        return controladorPlatos.verPlatoEnVistya(idPlato);
    }

    private void dadoQueExistenPlatosConAdicionales() {
        vegetariano = new TipoGusto(1L, "Vegetariano");
        Adicional ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        Adicional ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);
        List<Adicional> adicionales = new LinkedList();
        adicionales.add(ad1);
        adicionales.add(ad2);
        List<Plato> listaPlatos = new LinkedList();
        plato1 = new Plato(1L, vegetariano);
        plato2 = new Plato(2L, vegetariano);

        plato1.setAdicionales(adicionales);
        plato2.setAdicionales(adicionales);
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);

        when(servicioPlato.verPlatos()).thenReturn(listaPlatos);
    }

}