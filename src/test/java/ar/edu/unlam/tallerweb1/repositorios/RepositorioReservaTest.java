package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioReservaTest extends SpringTest {
    Cliente cliente = new Cliente(1L);
    @Autowired
    RepositorioReserva RepositorioReserva;

    @Test @Transactional @Rollback
    public void buscarReservas(){
        crearReservas();
        List<Reserva> reservas = RepositorioReserva.buscarTodasLasReservas();
        entoncesReservasEncontrados(reservas);
    }
    @Test @Transactional @Rollback
    public void buscarUnaReserva(){
        crearReservas();
        Long idCliente = cliente.getId();
        List<Reserva> reservas = RepositorioReserva.buscarReservasCliente(cliente);
        entoncesNoEncuentroReservas(reservas);
    }
    public void crearReservas(){
        Restaurante resto = new Restaurante();
        Mesa mesa1 = new Mesa(1L,resto,1,4);
        Mesa mesa2 = new Mesa(1L,resto,1,4);
        Mesa mesa3 = new Mesa(1L,resto,1,4);
        Mesa mesa4 = new Mesa(1L,resto,1,4);

        LocalDateTime date = LocalDateTime.of(2023,03,03,12,0,0);
        Reserva reserva1 = new Reserva(cliente,mesa1,date);
        Reserva reserva2 = new Reserva(cliente,mesa2,date);
        Reserva reserva3 = new Reserva(cliente,mesa3,date);
        Reserva reserva4 = new Reserva(cliente,mesa4,date);


        session().save(mesa1);
        session().save(mesa2);
        session().save(mesa3);
        session().save(mesa4);

        session().save(resto);

        session().save(cliente);

        session().save(reserva1);
        session().save(reserva2);
        session().save(reserva3);
        session().save(reserva4);
    }
    private void entoncesReservasEncontrados(List<Reserva> reservas ) {
        assertThat(reservas).isNotEmpty();
    }

    private void  entoncesNoTraeReservas(List<Reserva> reservas) { assertThat(reservas).isEmpty();}

    private void entoncesNoEncuentroReservas(List<Reserva> reservas) {
        assertThat(reservas).hasSize(0);
    }
}
