package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface RepositorioReserva {

    List<Plato> verPlatosDelCliente(Cliente cliente);

}
