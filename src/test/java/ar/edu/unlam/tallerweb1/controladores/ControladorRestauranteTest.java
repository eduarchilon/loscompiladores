package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.*;
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
    private ClienteService clienteService;
    private PedidoService pedidoService;
    private RestauranteService restauranteService;
    private ControladorMenu controladorMenu;
    private LocalidadService localidadService;



    private static final String VISTA_HOME = "home";
    private static final String VISTA_MENU = "menu-restaurante";

    @Before
    public void init(){
        servicioBusqueda = mock(ServicioBusqueda.class);
        clienteService = mock(ClienteService.class);
        pedidoService = mock(PedidoService.class);
        restauranteService = mock(RestauranteService.class);
        localidadService = mock(LocalidadService.class);
        controladorRestaurante = new ControladorRestaurante(servicioBusqueda, clienteService, pedidoService, restauranteService, localidadService);

        controladorMenu = new  ControladorMenu(restauranteService);
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


    @Test
    public void muestraLosRestaurantesMasValorados(){

        dadoQueExistanRestaurantesMasValorados(5);

        ModelAndView mav = cuandoBuscoRestaurantesMasValorados();

        entoncesVerEstaCantidad(mav, 5);

        entoncesMeLLevaALaVista(VISTA_HOME, mav.getViewName());
    }

    @Test
    public void queMuestreLosPlatosDelRestaurante(){
        Restaurante restoBuscado = new Restaurante(1L, "Resto-Buscado");

        List<Plato> platos = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            platos.add(new Plato());
        }
        when(restauranteService.verPlatosDelRestaurante(restoBuscado.getId())).thenReturn(platos);

        dadoQueTengaUnrestauranteValorado(restoBuscado);

        ModelAndView mav = cuandoBuscoPlatosDelRestaurante(restoBuscado.getId());

        entoncesEncuentroEnLaVistaDelMenu(mav, platos.size());

        entoncesMeLLevaALaVista(VISTA_MENU, mav.getViewName());

    }

    private void entoncesEncuentroEnLaVistaDelMenu(ModelAndView mav, int cantidad) {
        List<Plato> platosRestaurante = (List<Plato>) mav.getModel().get("platosRestaurante");
        assertThat(platosRestaurante).hasSize(cantidad);
    }

    private ModelAndView cuandoBuscoPlatosDelRestaurante(Long idRestaurante) {
        return controladorMenu.verCartaDelRestaurante(idRestaurante);
    }

    private void dadoQueTengaUnrestauranteValorado(Restaurante restaurante) {
        when(restauranteService.buscarRestaurantePorId(restaurante.getId())).thenReturn(restaurante);
    }

    private void entoncesVerEstaCantidad(ModelAndView mav, int cantidadEsperada) {

        List<Restaurante> restaurantes = (List<Restaurante>) mav.getModel().get("restosValorados");
        assertThat(restaurantes).hasSize(cantidadEsperada);
    }

    private ModelAndView cuandoBuscoRestaurantesMasValorados() {
        return controladorRestaurante.verRestaurantesMasValorados();
    }

    private void dadoQueExistanRestaurantesMasValorados(int cantidad) {
        List<Restaurante> valorados = new LinkedList<>();
        for (int i = 0; i < cantidad; i++) {
            valorados.add(new Restaurante(1L, 9, 23));
        }
        when(restauranteService.getRestaurantesMasCalificados()).thenReturn(valorados);
    }

}
