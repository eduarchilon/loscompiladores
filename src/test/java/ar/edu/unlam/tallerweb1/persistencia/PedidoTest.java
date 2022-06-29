package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class PedidoTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void crearPedido(){
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente());
        pedido.setListPlatos(new LinkedList());
        session().save(pedido);
        assertThat(pedido.getId()).isNotNull();
    }
}
