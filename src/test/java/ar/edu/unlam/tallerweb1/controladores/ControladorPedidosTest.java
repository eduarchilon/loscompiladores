package ar.edu.unlam.tallerweb1.controladores;



import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
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
    public static final Pedido PEDIDO_REALIZADO = new Pedido();
    public static final Long ID_CLIENTE = 1L;
    private HttpServletRequest request;
    private ControladorPedidos controladorPedido;
    private PedidoService servicioPedido;
    private ServicioDetallePedido servicioDetallePedido;


    @Before
    public void init(){
        servicioPedido= mock(PedidoService.class);
        servicioDetallePedido= mock(ServicioDetallePedido.class);
        controladorPedido = new ControladorPedidos(servicioPedido, servicioDetallePedido);

    }

    @Test
    public void prueba(){
        System.out.println("Hola");
    }

    @Test
    public void queSePuedaRealizarYMuestrarUnPedido(){

        dadoQueExistanUnPedidoRealizado(PEDIDO_REALIZADO);

        ModelAndView mav = cuandoBuscoUnPedidoRealizadoPorUnCliente();

        entoncesRegresoALaVistaPedido(VISTA_PEDIDO, mav);
    }

    private void entoncesRegresoALaVistaPedido(String nombreVista, ModelAndView mav) {
        List <DetallePedido> listaDetalles = (List<DetallePedido> ) mav.getModel().get("pedido");
        assertThat(mav.getViewName()).isEqualTo(nombreVista);
        assertThat(mav.getModel().get("pedido")).isEqualTo(listaDetalles);
    }

    private ModelAndView cuandoBuscoUnPedidoRealizadoPorUnCliente() {
        return controladorPedido.realizarPedido(request);
    }

    private void dadoQueExistanUnPedidoRealizado(Pedido pedido) {
        when(servicioPedido.verPedido(pedido)).thenReturn(new Pedido());
    }

    @Test
    public void queSePuedaRealizarUnPedido(){
        dadoQueExistenDetallesEnElPedido();

        ModelAndView mav = cuandoRealizoUnPedido();

        entoncesRegresoALaVistaPedido(VISTA_PEDIDO, mav);
    }

    private void dadoQueExistenDetallesEnElPedido() {
        List<DetallePedido> listaDetalles = new LinkedList<>();
        when(servicioDetallePedido.buscarPorIdCliente(request)).thenReturn(listaDetalles);
    }

    private ModelAndView cuandoRealizoUnPedido() {
        return controladorPedido.realizarPedido(request);
    }


}
