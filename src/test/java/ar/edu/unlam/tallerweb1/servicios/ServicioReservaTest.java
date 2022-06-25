package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReserva;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServicioReservaTest {

    private RepositorioReserva repositorioReserva;
    private RepositorioPlato repositorioPlato;
    private ServicioReservaImpl servicioReserva;


    @Before
    public void init(){
        //todo: aplicar mokito
//        repositorioReserva = mock(RepositorioReserva.class);
//        repositorioPlato = mock(RepositorioPlato.class);
//        servicioReserva = new ServicioReservaImpl(repositorioReserva,repositorioPlato);

    }

    @Test
    public void seCreaUnaReserva(){
        tengoEstaCantidadDePlatos(1);
        Reserva reserva = new Reserva(new Cliente(),new Mesa());
        obtengoUnaReserva(reserva);
    }

    public List<Plato> tengoEstaCantidadDePlatos(int cant) {
        List<Plato> lista = new LinkedList<>();
        for(int i = 0 ; i < cant; i++){
            lista.add(new Plato());
        }
        return lista;
        //when(repositorioPlato.buscarTodos()).thenReturn(lista);

    }

    public void esteClienteReservoEstePlato(){

    }

    public void obtengoUnaReserva(Reserva reserva) {
        assertThat(reserva).isNotNull();
    }
    public void noObtengoUnaReserva(Reserva reserva) {
        assertThat(reserva).isNull();
    }


}
