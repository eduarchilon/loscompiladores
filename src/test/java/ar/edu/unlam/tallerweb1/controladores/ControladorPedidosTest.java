package ar.edu.unlam.tallerweb1.controladores;



import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.forms.FormBuscarPlato;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioDetallePedido;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorPedidosTest {


    public static final String VISTA_PEDIDO = "pedido";
    public static final String VISTA_BUSCAR_PLATO = "buscarPlato";
    public static final Pedido PEDIDO_REALIZADO = new Pedido();
    public static final String NOMBRE_PLATO = "Empanada";

    private HttpServletRequest request;
    private ControladorPedidos controladorPedido;
    private PedidoService servicioPedido;
    private ServicioBusqueda servicioBusqueda;
    private ServicioDetallePedido servicioDetallePedido;


    @Before
    public void init(){
        servicioPedido= mock(PedidoService.class);
        servicioDetallePedido = mock(ServicioDetallePedido.class);
        servicioBusqueda = mock(ServicioBusqueda.class);
        controladorPedido = new ControladorPedidos(servicioPedido, servicioDetallePedido);

    }

    @Test
    public void queSeMuestrerElPedidoRealizadoPorElCliente(){

        dadoQueExistanUnPedidoRealizado(PEDIDO_REALIZADO);

        ModelAndView mav = cuandoBuscoUnPedidoRealizadoPorUnCliente();

        entoncesRegresoALaVistaPedido(VISTA_PEDIDO, mav);
    }

    @Test
    public void queSePuedaRealizarUnPedido(){
        dadoQueExistenDetallesEnElPedido();

        ModelAndView mav = cuandoRealizoUnPedido();

        entoncesRegresoALaVistaPedido(VISTA_PEDIDO, mav);
    }

    @Test
    public void queSePuedanAgregarDetallesAlPedido(){
        dadoQueExistanPlatos(NOMBRE_PLATO);

        ModelAndView mav = cuandoLoAgregoAUnPedido();

        entoncesRegresoABuscarPlato(VISTA_BUSCAR_PLATO, mav);

    }

    private void entoncesRegresoABuscarPlato(String nombreVista, ModelAndView mav) {
        List <DetallePedido> listaDetalles = (List<DetallePedido> ) mav.getModel().get("pedido");
        assertThat(mav.getViewName()).isEqualTo(nombreVista);
        assertThat(mav.getModel().get("pedido")).isEqualTo(listaDetalles);
    }

    private ModelAndView cuandoLoAgregoAUnPedido() {
        FormBuscarPlato form = new FormBuscarPlato();
        return controladorPedido.agregarPlatoAlDetallePedido(form, request);
    }

    private void dadoQueExistanPlatos(String nombrePlato) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombrePlato)).thenReturn(platos);
    }


    private void dadoQueExistanUnPedidoRealizado(Pedido pedido) {
        when(servicioPedido.verPedido(pedido)).thenReturn(new Pedido());
    }

    private void dadoQueExistenDetallesEnElPedido() {
        List<DetallePedido> listaDetalles = new LinkedList<>();
        when(servicioDetallePedido.buscarPorIdCliente(request)).thenReturn(listaDetalles);
    }



    private void entoncesRegresoALaVistaPedido(String nombreVista, ModelAndView mav) {
        List <DetallePedido> listaDetalles = (List<DetallePedido> ) mav.getModel().get("pedido");
        assertThat(mav.getViewName()).isEqualTo(nombreVista);
        assertThat(mav.getModel().get("pedido")).isEqualTo(listaDetalles);
    }



    private ModelAndView cuandoBuscoUnPedidoRealizadoPorUnCliente() {
        return controladorPedido.realizarPedido(request);
    }


    private ModelAndView cuandoRealizoUnPedido() {
        return controladorPedido.realizarPedido(request);
    }


}
