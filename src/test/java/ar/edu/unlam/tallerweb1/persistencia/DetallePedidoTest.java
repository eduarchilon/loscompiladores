package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class DetallePedidoTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void crearDetallePedido(){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCliente(new Cliente());
        detallePedido.setPlato(new Plato());
        session().save(detallePedido);
        assertThat(detallePedido.getId_detallePlato());
    }
}
