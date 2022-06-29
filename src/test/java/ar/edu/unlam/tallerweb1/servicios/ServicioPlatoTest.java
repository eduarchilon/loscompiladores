package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioPlatoTest {

    private RepositorioPedido repositorioPedido;
    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioCliente repositorioCliente;
    private RepositorioPlato repositorioPlato;
    private PedidoService pedidoService;
    private ServicioDetallePedido servicioDetallePedido;
    private HttpServletRequest request;
    private Plato platoSinventa;


    @Before
    public void init() {
        repositorioPedido = mock(RepositorioPedido.class);
        repositorioCliente = mock(RepositorioCliente.class);
        repositorioDetallePedido = mock(RepositorioDetallePedido.class);
        repositorioPlato = mock(RepositorioPlato.class);
        pedidoService = new PedidoServiceImpl(repositorioPedido, repositorioDetallePedido, repositorioCliente);
        servicioDetallePedido = new ServicioDetallePedidoImpl(repositorioDetallePedido, repositorioPlato, repositorioCliente);
        platoSinventa = new Plato();
    }


   /* @Test
    public void queSePuedaActualizarLaCantidadDeVentasDelPlato(){
        dadoQueExistaUnPlatoSinVentasNuevas();

        cuandoRealizoUnPedidoSeModificaLaCantidadVentasDelPlato();

        obtengoPlatoConNuevaVenta();

    }



    private void obtengoPlatoConNuevaVenta() {
    }

    private void dadoQueExistaUnPlatoSinVentasNuevas() {
        Plato platoSinVenta = new Plato();
        platoSinVenta.setCantVentas(0);
    }


    private void cuandoRealizoUnPedidoSeModificaLaCantidadVentasDelPlato() {
        pedidoService.realizarPedido(request);
    }
    */

}
