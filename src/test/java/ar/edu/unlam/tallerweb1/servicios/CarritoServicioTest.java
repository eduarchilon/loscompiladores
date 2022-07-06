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
    List<Plato> platos;

    @Before
    public void init() {
        repositorioCarrito = mock(RepositorioCarrito.class);
        carritoService = new CarritoServiceImpl(repositorioCarrito);

    }


    //
//    @Test
//    public void queMeMuestreInformacionDelCarrito(){
//
//        dadoQueExistenPlatos();
//
//        cuandoBuscoAlCarrito(1L);
//
//        System.out.println("***************************************");
//        for (int i = 0; i <carrito.getPlatos().size() ; i++) {
//            System.out.println(carrito.getPlatos().get(i).getDescripcion());
//        }
//        System.out.println("***************************************");
//
//    }
//

}
