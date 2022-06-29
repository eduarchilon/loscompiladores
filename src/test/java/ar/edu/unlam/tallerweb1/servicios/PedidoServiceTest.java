package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.LinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.mockito.Mockito.*;

public class PedidoServiceTest {

    private RepositorioPedido repositorioPedido;
    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioCliente repositorioCliente;
    private RepositorioPlato repositorioPlato;
    private PedidoService pedidoService;
    private ServicioDetallePedido servicioDetallePedido;
    private HttpServletRequest request;

    private Pedido pedido1;
    private Pedido pedido2;
    private Pedido pedido3;

    private Cliente ironMan;
    private Cliente hulk;

    private Plato plato1;
    private Plato plato2;
    private Plato plato3;

    private List<Pedido> listaPedidos;

    @Before
    public void init() {
        repositorioPedido = mock(RepositorioPedido.class);
        repositorioCliente = mock(RepositorioCliente.class);
        repositorioDetallePedido = mock(RepositorioDetallePedido.class);
        repositorioPlato = mock(RepositorioPlato.class);
        pedidoService = new PedidoServiceImpl(repositorioPedido, repositorioDetallePedido, repositorioCliente);
        servicioDetallePedido = new ServicioDetallePedidoImpl(repositorioDetallePedido, repositorioPlato, repositorioCliente);



        ironMan = new Cliente(1L, "Tony", "Stark", "20145236", "116589542");
        hulk = new Cliente(2L, "Bruce", "Banner", "20145236", "116589542");

        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", 2);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", 2);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", 2);

        List<Plato> platos = new LinkedList<>();

        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);

        pedido1 = new Pedido(1L, platos, ironMan);

        pedido2 = new Pedido(2L, platos, hulk);

        pedido3 = new Pedido(3L, platos, ironMan);

        listaPedidos = new LinkedList<>();
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);


    }

    @Test
    public void eliminarDuplicados() {

        List<Integer> numeros = new LinkedList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);

        HashSet<Integer> noDuplicados = new HashSet<Integer>();

        for (int i = 0; i < numeros.size() ; i++) {

                noDuplicados.add(numeros.get(i));

        }

        System.out.println("************************************");
        System.out.println(noDuplicados);
        System.out.println("*************************************");

    }

    @Test
    public void queMuestreLosPlatosDelPedido(){

        dadoQueExistenPedidos(listaPedidos);

        cuandoBuscoElPedido(pedido1);
        System.out.println("***************************************");

        List<Plato> listaPlatos = pedidoService.verPlatosDelPedido(pedido1);

        for (int i = 0; i <listaPlatos.size() ; i++) {
            System.out.println(listaPlatos.get(i).getDescripcion());
        }

        System.out.println("***************************************");


    }

    @Test
    public void queBusqueUnPedidoPorId(){
        dadoQueExistenPedidos(listaPedidos);

        cuandoBuscoElPedidoPorId(1L, pedido1);

        entoncesMeDiceSiLoEncontro(pedido2, 2L);

    }




    private void entoncesMeDiceSiLoEncontro(Pedido idPedido, Long id) {
        assertThat(id).isEqualTo(idPedido.getId());
    }

    private void cuandoBuscoElPedidoPorId(Long idPedido, Pedido buscado) {
        when(pedidoService.buscarPedidoPorId(idPedido)).thenReturn(buscado);
        Pedido encontrado = pedidoService.buscarPedidoPorId(buscado.getId());
        System.out.println(encontrado.getListPlatos().get(0).getDescripcion());
    }

    private void cuandoBuscoElPedido(Pedido pedido) {
        when(pedidoService.verPedido(pedido)).thenReturn(pedido1);
    }

    private void dadoQueExistenPedidos(List<Pedido> pedidos) {

    when(repositorioPedido.verPedidos()).thenReturn(pedidos);

    }

}
