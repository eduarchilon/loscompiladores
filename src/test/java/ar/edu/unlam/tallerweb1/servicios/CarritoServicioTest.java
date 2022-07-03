package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarrito;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

public class CarritoServicioTest {

    private RepositorioCarrito repositorioCarrito;
    private CarritoService carritoService;
    private Plato plato1;
    private Plato plato2;
    private Plato plato3;
    private Plato plato4;
    private Carrito carrito;

    @Before
    public void init() {
        repositorioCarrito = mock(RepositorioCarrito.class);
        carritoService = new CarritoServiceImpl(repositorioCarrito);

    }

    @Test
    public void queMeMuestreInformacionDelCarrito(){

        dadoQueExistenPlatos();

        cuandoBuscoAlCarrito(1L);

        System.out.println("***************************************");
        for (int i = 0; i <carrito.getPlatos().size() ; i++) {
            System.out.println(carrito.getPlatos().get(i).getDescripcion());
        }
        System.out.println("***************************************");

    }

    private void cuandoBuscoAlCarrito(long idCarrito) {
        when(repositorioCarrito.verCarrito(idCarrito)).thenReturn(carrito);
    }

    private void dadoQueExistenPlatos() {
        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", 2);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", 2);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", 2);
        plato4 = new Plato(4L, TipoPlato.VEGANO, "plato1", 4);

        List<Plato> platos = new LinkedList<>();

        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);

        carrito = new Carrito(1L, platos);

    }
}
