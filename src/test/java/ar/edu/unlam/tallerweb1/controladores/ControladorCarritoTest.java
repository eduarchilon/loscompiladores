package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.CarritoAdicional;
import ar.edu.unlam.tallerweb1.servicios.CarritoService;
import ar.edu.unlam.tallerweb1.servicios.CuponService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorCarritoTest {

    private CarritoService carritoService;
    private CuponService cuponService;
    private ControladorCarrito controladorCarrito;

    public static final String VISTA_CARRITO = "carrito";

    String pSearchTerm = "";
    private HttpServletRequest request;
    private HttpServletResponse response;


    @Before
    public void init(){
        this.carritoService = mock(CarritoService.class);
        this.cuponService = mock(CuponService.class);
        controladorCarrito = new ControladorCarrito(carritoService, cuponService);
    }

    //El carrito hace alucion a una lista d ecarritos o opedidos que dentro de la misma hay platos en cada una
    @Test
    public void queMuestreElCarrito() throws IOException {
        dadoQueExistanPlatosenElCarrito(5);

        ModelAndView mav = cuandoBuscoLosCarritos(pSearchTerm, request, response);

        entoncesEncuentro(mav, 5);

        entoncesMeLLevaALaVista(VISTA_CARRITO, mav.getViewName());
    }



    //    Carrito Adicionales

    @Test
    public void queMuestreElCarritoAdicional() throws IOException {
        dadoQueExistanAdicionalesEnElCarrito(5);

        ModelAndView mav = cuandoBuscoLosCarritos(pSearchTerm, request, response);

        entoncesEncuentroAdicionales(mav, 5);

        entoncesMeLLevaALaVista(VISTA_CARRITO, mav.getViewName());
    }

    private void entoncesEncuentroAdicionales(ModelAndView mav, int cantidad) {
        List<CarritoAdicional> lista = (List<CarritoAdicional>) mav.getModel().get("adicionalesCarrito");
        assertThat(lista).hasSize(cantidad);
    }

    private void dadoQueExistanAdicionalesEnElCarrito(int cantidad) {
        List<CarritoAdicional> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new CarritoAdicional());
        }
        when(carritoService.verListDeAdicionalesDelCarrito()).thenReturn(lista);
    }


    private void entoncesMeLLevaALaVista(String vistaCarrito, String viewName) {
        assertThat(vistaCarrito).isEqualTo(viewName);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidad) {
        List<Carrito> lista = (List<Carrito>) mav.getModel().get("platosCarrito");
        assertThat(lista).hasSize(cantidad);
    }

    private ModelAndView cuandoBuscoLosCarritos(String pSearchTerm, HttpServletRequest request, HttpServletResponse response)throws IOException {
        return controladorCarrito.verCarritoModal(pSearchTerm, request, response);
    }

    private void dadoQueExistanPlatosenElCarrito(int cantidad) {
        List<Carrito> lista = new LinkedList<>();
        for(int i = 0 ; i < cantidad; i++){
            lista.add(new Carrito());
        }
        when(carritoService.verListDePlatosDelCarrito()).thenReturn(lista);
    }
}