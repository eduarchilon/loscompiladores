package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.List;

public interface RepositorioReserva {

    List<Plato> verPlatosDelCliente(Cliente cliente);

    List<Reserva> buscarTodasLasReservas();

    List<Reserva> buscarUnaReservas();

    List<Reserva> buscarReservasCliente(Cliente cliente);
}
