package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

import static ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato.VEGANO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioPlatoTest {

    private RepositorioPedido repositorioPedido;
    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioCliente repositorioCliente;
    private RepositorioPlato repositorioPlato;
    private PedidoService pedidoService;
    private PlatoService platoService;
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
        platoService = new PlatoServiceImpl(repositorioPlato);
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

    @Test @Transactional
    @Rollback
    public void buscarUnPlatoDeLaLista(){

        Plato plato1 = new Plato(1L,VEGANO,"Milanesa con pure",1);
        Plato plato2 = new Plato(2L, VEGANO,"Milanesa con papas fritas",2);
        Plato plato3 = new Plato(3L, VEGANO,"Milanesa de berenjena con pure",3);
        Plato plato4 = new Plato(4L, VEGANO,"Arroz al wok con verduras",10);

        List<Plato> platos = new LinkedList<>();
        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);
        platos.add(plato4);

        when(platoService.buscarPlato(plato1.getId())).thenReturn(plato1);

        Plato platoBuscado = platoService.buscarPlato(1L);

        assertThat(platoBuscado.getId()).isEqualTo(1L);
    }

    @Test
    public void verEltotalPrecioPorAgregacionDeAdicionales(){
        Adicional a = new Adicional(1L, "a", 200.0);
        Adicional b = new Adicional(2L, "b", 200.0);
        Adicional c = new Adicional(3L, "c", 200.0);

        Plato plato1 = new Plato(1L,VEGANO,"Milanesa con pure",1);

        List<Adicional> aa = new LinkedList<>();
        aa.add(a);
        aa.add(b);
        aa.add(c);

        when(platoService.buscarPlato(1L)).thenReturn(plato1);
        Plato platoBuscado = platoService.buscarPlato(1L);

        when(platoService.verAdicionalesDeLPlato(platoBuscado.getId())).thenReturn(aa);

        List<Adicional> adiconales = platoService.verAdicionalesDeLPlato(platoBuscado.getId());

        platoBuscado.setAdicionales(adiconales);

        System.out.println(platoBuscado.getAdicionales());

    }

}
