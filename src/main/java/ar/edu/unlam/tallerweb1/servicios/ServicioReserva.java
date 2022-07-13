package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import java.util.List;

public interface ServicioReserva {

    List<Plato> cartaClientePorGusto(Cliente cliente);


    Reserva buscarReserva(Long id);

    List<Reserva> buscoTodasLasReservas();

    Long creoUnaReserva(Reserva reserva);

    Boolean eliminarReserva(Long reserva);

    List<Reserva> buscoTodasLasReservasClientes(Cliente cliente);
}
