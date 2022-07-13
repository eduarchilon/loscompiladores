package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.*;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service @Transactional
public class ServicioReservaImpl implements ServicioReserva{
    private RepositorioReserva repositorioReserva;
    private RepositorioPlato repositorioPlato;

    @Autowired
    public ServicioReservaImpl(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    @Override
    public List<Plato> cartaClientePorGusto(Cliente cliente) {
        List<Plato> platos = repositorioReserva.verPlatosDelCliente(cliente);
        return platos;
    }

    @Override
    public Reserva buscarReserva(Long id) {
        Reserva reserva = repositorioReserva.buscarReservaPorId(id);
        return reserva;
    }

    @Override
    public List<Reserva> buscoTodasLasReservas() {
        return repositorioReserva.buscarTodasLasReservas();
    }

    @Override
    public Long creoUnaReserva(Reserva reserva) {
        Mesa mesa = reserva.getMesa();
        Restaurante resto = mesa.getRestaurante();
        if (resto.getHorarioApertura() < reserva.getHorario() && reserva.getHorario() < resto.getHorarioCierre()){
            return repositorioReserva.crearReserva(reserva);
        }
        return null;
    }

    @Override
    public Boolean eliminarReserva(Long reserva) {
        //todo: cuando tengamos login se pueda validar el cliente
        return repositorioReserva.eliminarReserva(reserva);
    }

    @Override
    public List<Reserva> buscoTodasLasReservasClientes(Cliente cliente) {

        return repositorioReserva.buscarReservasCliente(cliente);
    }
}

