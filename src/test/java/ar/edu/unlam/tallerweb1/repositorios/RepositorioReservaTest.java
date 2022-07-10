package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioReservaTest extends SpringTest {
    Cliente cliente = new Cliente(1L);
    Restaurante resto = new Restaurante(1L, 9, 23);
//    LocalDateTime fechaReserva = LocalDateTime.of(2023,03,03,12,0,0);
//    Date date = new Date();
    Calendar date = new GregorianCalendar(2023,12,12,12,00);
    @Autowired
    private RepositorioReserva repositorioReserva;


    private Mesa mesa1 ;
    private Mesa mesa2 ;
    private Mesa mesa3 ;
    private Mesa mesa4 ;
    private Mesa mesa5 ;
    private Mesa mesa6 ;
    private Mesa mesa7 ;


    private Reserva reserva1 ;
    private Reserva reserva2 ;
    private Reserva reserva3 ;
    private Reserva reserva4 ;


    @Test @Transactional @Rollback
    public void buscarReservas(){
        crearReservas();
        List<Reserva> reservas = repositorioReserva.buscarTodasLasReservas();
        entoncesReservasEncontrados(reservas);
    }
    @Test @Transactional @Rollback
    public void buscarUnaReserva(){
        crearReservas();
        Reserva reservaBuscada = repositorioReserva.buscarReservaPorId(reserva1.getId());
        entoncesReservaEncontrada(reservaBuscada);
    }
    @Test @Transactional @Rollback
    public void buscarReservasPorResto(){
        crearReservas();
        List<Reserva> reservasBuscadas = repositorioReserva.buscarTodasLasReservasRestaurante(resto.getId());
        entoncesReservasEncontradas(reservasBuscadas);
    }



    @Test @Transactional @Rollback
    public void buscarReservasCliente(){
        crearReservas();
        List<Reserva> reservas = repositorioReserva.buscarReservasCliente(cliente);
        entoncesReservasEncontrados(reservas);
    }
    @Test @Transactional @Rollback
    public void muestraDisponibilidad(){
        crearReservas();
        List<Mesa> mesas = repositorioReserva.buscaMesasDisponibles(resto,date);
        entoncesMesasEncontrados(mesas);
    }
    @Test @Transactional @Rollback
    public void muestraDisponibilidadSegunHorario(){
        crearReservas();
//        LocalDateTime fechaReserva = LocalDateTime.of(2022,06,18,12,0,0);
System.out.println(resto.getId());
        List<Mesa> mesas = repositorioReserva.buscaMesasDisponiblesSegunHorario(resto,date);
        entoncesMesasEncontrados(mesas);
    }
    @Test @Transactional @Rollback
    public void creaUnaReserva(){
        Reserva reservaCreada = new Reserva(1L,date);
        repositorioReserva.crearReserva(reservaCreada);
        Reserva buscada = repositorioReserva.buscarReservaPorId(1L);
        entoncesReservaEncontrada(reservaCreada,buscada);

    }

    private void entoncesReservaEncontrada(Reserva reservaCreada, Reserva buscada) {
        assertThat(reservaCreada.getId()).isEqualTo(buscada.getId());
    }

    public void crearReservas(){

        this.mesa1 = new Mesa(1L,resto,1,4);
        this.mesa2 = new Mesa(1L,resto,2,4);
        this.mesa3 = new Mesa(1L,resto,3,4);
        this.mesa4 = new Mesa(1L,resto,4,4);
        this.mesa5 = new Mesa(1L,resto,5,4);
        this.mesa6 = new Mesa(1L,resto,6,4);
        this.mesa7 = new Mesa(1L,resto,7,4);


        this.reserva1 = new Reserva(cliente,mesa1,date);
        this.reserva2 = new Reserva(cliente,mesa2,date);
        this.reserva3 = new Reserva(cliente,mesa3,date);
        this.reserva4 = new Reserva(cliente,mesa4,date);

        session().save(this.mesa1);
        session().save(this.mesa2);
        session().save(this.mesa3);
        session().save(this.mesa4);
        session().save(this.mesa5);
        session().save(this.mesa6);
        session().save(this.mesa7);

        session().save(this.resto);

        session().save(this.cliente);

        session().save(this.reserva1);
        session().save(this.reserva2);
        session().save(this.reserva3);
        session().save(this.reserva4);
    }
    private void entoncesReservasEncontrados(List<Reserva> reservas ) {
        System.out.println(reservas);
        assertThat(reservas).isNotEmpty();
    }
    private void entoncesReservaEncontrada(Reserva reserva ) {
        System.out.println(reserva);
        assertThat(reserva).isEqualTo(reserva1);
    }
    private void entoncesReservaCreada(Reserva reserva, Reserva reservaBuscada ) {
        System.out.println(reserva);
        assertThat(reserva).isEqualTo(reservaBuscada);
    }
    private void entoncesReservasEncontradas(List<Reserva> reservasBuscadas) {
        System.out.println(reservasBuscadas);
        assertThat(reservasBuscadas).hasSize(4);
    }

    private void entoncesMesasEncontrados(List<Mesa> mesas ) {
        assertThat(mesas).isNotEmpty();
    }
    private void  entoncesNoTraeReservas(List<Reserva> reservas) { assertThat(reservas).isEmpty();}

    private void entoncesNoEncuentroReservas(List<Reserva> reservas) {
        assertThat(reservas).hasSize(0);
    }
}
