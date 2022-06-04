package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ClienteService {

    Cliente verCliente(Cliente id);

    Usuario obtenerClientePorNombre(Cliente cliente);
}