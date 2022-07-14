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
    private MesaService repositorioMesa;
    private RepositorioPlato repositorioPlato;
    private ServicioReservaImpl servicioReserva;

    Cliente cliente = new Cliente(1L);
    Restaurante resto = new Restaurante(1L,9,23);
    Calendar date = new GregorianCalendar(2023,12,12,12,00);
    Calendar date2 = new GregorianCalendar(2023,12,12,11,00);
    Calendar dateFueraDeHora = new GregorianCalendar(2023,12,12,8,00);

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
        repositorioMesa = mock(MesaService.class);
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
        crearReservas();
        Reserva reserva = new Reserva(cliente,mesa1,date);
        when(servicioReserva.creoUnaReserva(reserva)).thenReturn(0L);
        Long idReserva =servicioReserva.creoUnaReserva(reserva);

        seCreaUnaReserva(idReserva);

    }
    @Test
    public void seEliminaUnaReservaDeLaLista(){
        crearReservas();
        Reserva reserva = new Reserva(cliente,mesa1,date);
        when(servicioReserva.eliminarReserva(reserva.getId())).thenReturn(true);
        Boolean resultadoReserva = servicioReserva.eliminarReserva(reserva.getId());
        seEliminaUnaReserva(resultadoReserva);

    }




    @Test
    public void noSeCreaUnaReserva(){

        crearReservas();
        Reserva reserva = new Reserva(cliente,mesa1,dateFueraDeHora);

        when(servicioReserva.creoUnaReserva(reserva)).thenReturn(null);
        Long idReserva = servicioReserva.creoUnaReserva(reserva);
        noSeCreaUnaReserva(idReserva);
    }
    @Test
    public void traigoTodasLasReservas(){
        crearReservas();
        tengoUnaListaDeReservas(this.listReservas);
        List<Reserva> reservasBuscadas = servicioReserva.buscoTodasLasReservas();
        obtengoUnaListaDeReservas(reservasBuscadas);
    }
    @Test
    public void traigoLasReservasDelCliente(){
        crearReservas();
//        tengoUnaListaDeReservas(this.listReservas);
        cuandoBuscoLaReservaDelCliente(this.listReservas,cliente);
        List<Reserva> reservasBuscadas = servicioReserva.buscoTodasLasReservasClientes(cliente);
        obtengoUnaListaDeReservas(reservasBuscadas);
    }
    @Test
    public void traigoDisponiblesReservasDelCliente(){
        crearReservas();
        tengoUnaListaDeMesas(this.listMesas,resto,date);
        List<Mesa> mesasBuscadas = servicioReserva.buscaMesasDisponiblesSegunHorario(resto,date);
        obtengoUnaListaDeMesas(mesasBuscadas);
    }



    private void tengoUnaListaDeMesas(List<Mesa> mesasBuscadas, Restaurante resto, Calendar date) {
        when(servicioReserva.buscaMesasDisponiblesSegunHorario(resto,date)).thenReturn(mesasBuscadas);
    }


    private void cuandoBuscoLaReservaDelCliente(LinkedList<Reserva> listReservas, Cliente cliente) {
        when(servicioReserva.buscoTodasLasReservasClientes(cliente)).thenReturn(listReservas);
    }


    private void tengoUnaListaDeReservas(LinkedList<Reserva> listReservas) {
        when(servicioReserva.buscoTodasLasReservas()).thenReturn(listReservas);
    }
    private void crearReserva() {
        when(servicioReserva.buscoTodasLasReservas()).thenReturn(listReservas);
    }

    private void tengoUnaReserva(Reserva reserva1) {
        when(repositorioReserva.buscarReservaPorId(reserva1.getId())).thenReturn(reserva1);
        when(servicioReserva.buscarReserva(reserva1.getId())).thenReturn(reserva1);
    }

    private void seEliminaUnaReserva(Boolean resultadoReserva) {
        assertThat(resultadoReserva).isTrue();
    }
    private void obtengoUnaListaDeMesas(List<Mesa> mesasBuscadas) {
        assertThat(mesasBuscadas).hasSize(7);
    }
    public void obtengoUnaReserva(Reserva reserva) {
        assertThat(reserva).isNotNull();
    }
    private void obtengoUnaListaDeReservas(List<Reserva> reservasBuscadas) {
        assertThat(reservasBuscadas).hasSize(4);
    }
    public void seCreaUnaReserva(Long idReserva) {
        assertThat(idReserva).isEqualTo(0);
    }
    public void noSeCreaUnaReserva(Long idReserva) {
        assertThat(idReserva).isNull();
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
        this.listMesas.add(mesa1);
        this.listMesas.add(mesa2);
        this.listMesas.add(mesa3);
        this.listMesas.add(mesa4);
        this.listMesas.add(mesa5);
        this.listMesas.add(mesa6);
        this.listMesas.add(mesa7);

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
