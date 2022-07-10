package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
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
}

