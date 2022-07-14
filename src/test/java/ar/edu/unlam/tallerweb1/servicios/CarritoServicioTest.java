package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.CarritoAdicional;
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
    private Carrito carrito1;
    private Carrito carrito2;
    private List<Carrito> carritos;
    private List<CarritoAdicional> carritosAdicionales;
    private CarritoAdicional carritoA1;
    private CarritoAdicional carritoA2;
    private Adicional ad1;
    private Adicional ad2;

    @Before
    public void init() {
        repositorioCarrito = mock(RepositorioCarrito.class);
        carritoService = new CarritoServiceImpl(repositorioCarrito);

    }



    @Test
    public void queMeMuestreInformacionDelCarrito(){

        dadoQueExistenPlatos();

        carritos = new LinkedList<>();
        carritos.add(carrito1);
        carritos.add(carrito2);

        when(carritoService.verListDePlatosDelCarrito()).thenReturn(carritos);
        List<Carrito> cars = carritoService.verListDePlatosDelCarrito();

        assertThat(carritos).hasSize(2);

    }

    @Test
    public void queMeMuestreInformacionDelCarritoAdicional(){

        dadoQueExistenAdicionales();

        carritosAdicionales = new LinkedList<>();
        carritosAdicionales.add(carritoA1);
        carritosAdicionales.add(carritoA2);

        when(carritoService.verListDeAdicionalesDelCarrito()).thenReturn(carritosAdicionales);
        List<CarritoAdicional> cars = carritoService.verListDeAdicionalesDelCarrito();

        assertThat(carritosAdicionales).hasSize(2);

    }

    private void dadoQueExistenAdicionales() {
        ad1 = new Adicional(1L, "Pan", 10.00);
        ad2 = new Adicional(2L, "Agua", 10.00);
        carritoA1 = new CarritoAdicional(1L, ad1);
        carritoA2 = new CarritoAdicional(2L, ad2);
    }


    private void dadoQueExistenPlatos() {

        plato1 = new Plato(1L);
        plato2 = new Plato(2L);
        plato1.setPrecio(100.0);
        plato2.setPrecio(100.0);
        carrito1 = new Carrito(1L, plato1);
        carrito2 = new Carrito(2L, plato2);
    }


}
