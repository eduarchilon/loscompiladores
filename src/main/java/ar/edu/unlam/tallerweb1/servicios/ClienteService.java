package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;


public interface ClienteService {

    Cliente verCliente(Cliente id);

    Cliente obtenerClientePorNombre(String cliente);

    List<Cliente> verClientes();
}
