package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioPedidoTest extends SpringTest {

    @Autowired
    private RepositorioPedido repositorioPedido;

    private Pedido pedido1;

    private Pedido pedido2;

    private Pedido pedido3;

    private Cliente ironMan;

    private Cliente hulk;

    @Before
    public void init() {

    }

    @Test @Transactional @Rollback
    public void queDevuelvaUnPedidoBuscado(){
        dadoQueExistenPedidos();

        Pedido buscado = repositorioPedido.buscarPedido(pedido1.getId());


        assertThat(buscado).isEqualTo(pedido1);
    }

    @Test @Transactional @Rollback
    public void queDevuelvaLosPedidosDeUnClinte(){
        /*Busco si el cliente tiene pedido*/
        dadoQueExistenPedidos();

        List<Pedido> pedidos = repositorioPedido.buscarPedidosCliente(ironMan);

        assertThat(pedidos.size()).isEqualTo(2);

    }


    private void dadoQueExistenPedidos() {
        ironMan = new Cliente(1L , "Tony",  "Stark", "20145236", "116589542");
        hulk = new Cliente(2L , "Bruce",  "Banner", "20145236", "116589542");

        session().save(ironMan);
        session().save(hulk);

        Plato plato1 = new Plato(TipoPlato.VEGANO, "plato1", 2);
        Plato plato2 = new Plato( TipoPlato.VEGANO, "plato2", 2);
        Plato plato3 = new Plato( TipoPlato.VEGANO, "plato3", 2);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);

        List<Plato> platos = new LinkedList<>();

        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);


        pedido1 = new Pedido(1L, platos, ironMan);

        pedido2 = new Pedido(2L, platos, hulk);

        pedido3 = new Pedido(3L, platos, ironMan);


        session().save(pedido1);
        session().save(pedido2);
        session().save(pedido3);

    }


}