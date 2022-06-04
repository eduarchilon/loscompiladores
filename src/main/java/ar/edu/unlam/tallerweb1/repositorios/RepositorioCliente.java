package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioCliente {

    Cliente buscarPorId(Long idCliente);

    Usuario buscarPorUsuario(Usuario usuarioCliente);

    Usuario buscarPorNombre(String nombre);

}
