package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReserva;

import java.util.List;

public interface ServicioReserva {

    List<Plato> cartaClientePorGusto(Cliente cliente);

    Boolean borrarReservaDeLaLista(Long idReserva);

    Reserva buscarReserva(Long id);

    List<Reserva> buscoTodasLasReservas();

    Long creoUnaReserva(Reserva reserva);

    void agregarMesaAlaReserva(Long idMesa);


}
