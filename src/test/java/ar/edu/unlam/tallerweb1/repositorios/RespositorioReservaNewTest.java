package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

public class RespositorioReservaNewTest extends SpringTest {

    @Autowired
    private RepositorioReserva repositorioReserva;

    @Test @Rollback @Transactional
    public void quePuedaCrearUnaRserva(){

//        Cliente cliente, Mesa mesa, Calendar fecha



        Reserva reservaCreada = new Reserva(1L);
        repositorioReserva.crearReserva(reservaCreada);
        Reserva buscada = repositorioReserva.buscarReservaPorId(1L);

        System.out.println("-------------------------------------------");
        System.out.println(buscada.getId());
        System.out.println("-------------------------------------------");
    }
}
