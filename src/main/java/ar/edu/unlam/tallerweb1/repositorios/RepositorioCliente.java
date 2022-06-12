package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

public interface RepositorioCliente {

    Cliente buscarPorId(Long idCliente);

    Usuario buscarPorUsuario(Usuario usuarioCliente);

    Usuario buscarPorNombre(String nombre);

    List<Cliente> buscarCliente();
}
