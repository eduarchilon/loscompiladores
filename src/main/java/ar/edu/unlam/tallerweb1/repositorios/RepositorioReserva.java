package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface RepositorioReserva {

    List<Plato> verPlatosDelCliente(Cliente cliente);

    List<Reserva> buscarTodasLasReservas();

    List<Reserva> buscarUnaReservas();

    List<Reserva> buscarReservasCliente(Cliente cliente);

    List<Mesa> buscaMesasDisponibles(Restaurante resto, Date fechaReserva);


    List<Mesa> buscaMesasDisponiblesSegunHorario(Restaurante resto, Date fechaReserva);
}
