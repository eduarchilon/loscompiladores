package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.Calendar;
import java.util.List;

public interface RepositorioReserva {

    List<Plato> verPlatosDelCliente(Cliente cliente);

    List<Reserva> buscarTodasLasReservas();

    List<Reserva> buscarUnaReservas();

    List<Reserva> buscarReservasCliente(Cliente cliente);

    List<Mesa> buscaMesasDisponibles(Restaurante resto, Calendar fechaReserva);


    List<Mesa> buscaMesasDisponiblesSegunHorario(Restaurante resto, Calendar fechaReserva);

    Reserva buscarReservaPorId(Long id);

    List<Reserva> buscarTodasLasReservasRestaurante(Long id);

    Long crearReserva(Reserva reserva1);

    Boolean borrarReserva(Long idReserva);

    void cargarMesaAlaReserva(Long idMesa);
}
