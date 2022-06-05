package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositorioClienteTest extends SpringTest {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Test @Transactional @Rollback
    public void buscarClientePorId(){
        Cliente cliente1 = new Cliente();
        session().save(cliente1);
        Long idCliente = cliente1.getId();

        Cliente resultado = repositorioCliente.buscarPorId(idCliente);

        assertThat(resultado).isEqualTo(cliente1);
    }

    @Test @Transactional @Rollback
    public void buscarClientePorUsuario(){
//        Cliente cliente1 = new Cliente();
//        session().save(cliente1);
//        Usuario usuarioCliente = cliente1.getUsuario();
//
//        Usuario resultado = repositorioCliente.buscarPorUsuario(usuarioCliente);
//
//        assertThat(resultado).isEqualTo(cliente1);
    }
}
