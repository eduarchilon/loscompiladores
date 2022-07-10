package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReserva;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioReservaTest {

    private RepositorioReserva repositorioReserva;
    private RepositorioPlato repositorioPlato;
    private ServicioReservaImpl servicioReserva;

    Cliente cliente = new Cliente(1L);
    Restaurante resto = new Restaurante();
    Calendar date = new GregorianCalendar(2023,12,12,12,00);
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
    private LinkedList<Mesa> listMesas;
    private LinkedList<Reserva> listReservas;

    @Before
    public void init(){
        //todo: aplicar mokito
        repositorioReserva = mock(RepositorioReserva.class);
        servicioReserva = new ServicioReservaImpl(repositorioReserva);


    }


    //buscarReservas()
    //buscarUnaReserva()
    //muestraDisponibilidad()
    //muestraDisponibilidadSegunHorario()
    //crearReservas()
    //buscarUnaReserva()
    @Test
    public void seBuscaUnaReserva(){
        crearReservas();
        tengoUnaReserva(reserva1);
        Reserva reservaBuscada = servicioReserva.buscarReserva(reserva1.getId());
        obtengoUnaReserva(reservaBuscada);
    }
    @Test
    public void seCreaUnaReserva(){
        Reserva reserva = new Reserva(cliente,mesa1,date);
        //todo: setear horario reserva
        //todo: setear horario apertura y cierre restaurante
        if (resto.getHorarioApertura() < reserva.getHorario() && reserva.getHorario() < resto.getHorarioCierre()){

        }
    }
    @Test
    public void noSeCreaUnaReserva(){

    }
    @Test
    public void traigoTodasLasReservas(){
        crearReservas();
        tengoUnaListaDeReservas(this.listReservas);
        List<Reserva> reservasBuscadas = servicioReserva.buscoTodasLasReservas();
        obtengoUnaListaDeReservas(reservasBuscadas);
    }



    private void tengoUnaListaDeReservas(LinkedList<Reserva> listReservas) {
        when(servicioReserva.buscoTodasLasReservas()).thenReturn(listReservas);
    }


    private void tengoUnaReserva(Reserva reserva1) {
        when(repositorioReserva.buscarReservaPorId(reserva1.getId())).thenReturn(reserva1);
        when(servicioReserva.buscarReserva(reserva1.getId())).thenReturn(reserva1);
    }


    public void obtengoUnaReserva(Reserva reserva) {
        assertThat(reserva).isNotNull();
    }
    private void obtengoUnaListaDeReservas(List<Reserva> reservasBuscadas) {
        assertThat(reservasBuscadas).hasSize(4);
    }
    public void noObtengoUnaReserva(Reserva reserva) {
        assertThat(reserva).isNull();
    }

    public void crearReservas(){

        this.mesa1 = new Mesa(1L,resto,1,4);
        this.mesa2 = new Mesa(1L,resto,2,4);
        this.mesa3 = new Mesa(1L,resto,3,4);
        this.mesa4 = new Mesa(1L,resto,4,4);
        this.mesa5 = new Mesa(1L,resto,5,4);
        this.mesa6 = new Mesa(1L,resto,6,4);
        this.mesa7 = new Mesa(1L,resto,7,4);
        this.listMesas = new LinkedList<Mesa>();

        this.reserva1 = new Reserva(1L,cliente,mesa1,date);
        this.reserva2 = new Reserva(2L,cliente,mesa2,date);
        this.reserva3 = new Reserva(3L,cliente,mesa3,date);
        this.reserva4 = new Reserva(4L,cliente,mesa4,date);
        this.listReservas = new LinkedList<Reserva>();
        this.listReservas.add(reserva1);
        this.listReservas.add(reserva2);
        this.listReservas.add(reserva3);
        this.listReservas.add(reserva4);

    }


}
