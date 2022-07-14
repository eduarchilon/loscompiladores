package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.servicios.CarritoService;
import ar.edu.unlam.tallerweb1.servicios.CuponService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladoCuponTest {


    private CarritoService carritoService;
    private CuponService cuponService;
    private ControladorCarrito controladorCarrito;
    public static final String VISTA_CARRITO = "carrito";
    private Cupon tuenti;

    String pSearchTerm = "";
    private HttpServletRequest request;
    private HttpServletResponse response;


    @Before
    public void init(){
        this.carritoService = mock(CarritoService.class);
        this.cuponService = mock(CuponService.class);
        controladorCarrito = new ControladorCarrito(carritoService, cuponService);
    }

    @Test
    public void queValideElCupon() throws IOException {
        dadoQueExistaUncupon(tuenti);

        ModelAndView mav = cuandoBuscoLosCarritos(pSearchTerm, request, response);

        entoncesEncuentro(mav, tuenti);

        entoncesMeLLevaALaVista(VISTA_CARRITO, mav.getViewName());
    }

    private void entoncesMeLLevaALaVista(String vistaCarrito, String viewName) {
        assertThat(vistaCarrito).isEqualTo(viewName);
    }

    private void entoncesEncuentro(ModelAndView mav, Cupon tuenti) {
        Cupon cuponNuevo =  (Cupon) mav.getModel().get("cupon");
        assertThat(cuponNuevo).isEqualTo(tuenti);
    }

    private void dadoQueExistaUncupon(Cupon tuenti) {
        tuenti = new Cupon(1L, "TUENTI", 10);
        when(cuponService.obetenerCupon(tuenti.getNombre())).thenReturn(tuenti);
    }

    private ModelAndView cuandoBuscoLosCarritos(String pSearchTerm, HttpServletRequest request, HttpServletResponse response)throws IOException {
        return controladorCarrito.verCarritoModal(pSearchTerm, request, response);
    }

}
