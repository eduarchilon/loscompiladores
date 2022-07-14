package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class RepositorioCarritoTest extends SpringTest {


    @Autowired
    private RepositorioCarrito repositorioCarrito;

    private Restaurante restoA;
    private Restaurante restoB;
    private Plato plato1;
    private Plato plato2;
    private Plato plato3;
    private Plato plato4;
    private Carrito carrito2;
    private Carrito carrito1;
    private Carrito carrito3;
    private Carrito carrito4;
    private CarritoAdicional carritoA1;
    private CarritoAdicional carritoA2;
    private Adicional ad1;
    private Adicional ad2;


    @Before
    public void init(){

    }

    @Test
    @Transactional
    @Rollback(false)
    public void queMeMuestreLosPlatosDelCarrito() {
        dadoQueExistenPlatos();

        List<Carrito> platosBuscados = repositorioCarrito.verTodosLosPlatos();

        System.out.println("***************************************");
        for (int i = 0; i < platosBuscados.size(); i++) {
            System.out.println("PLATO: "+ platosBuscados.get(i));
        }
        System.out.println("***************************************");

    }

    @Test
    @Transactional
    @Rollback(false)
    public void queMeMuestreLosAdicionalesDelCarrito() {
        dadoQueExistenAdicionales();

        List<CarritoAdicional> adicionalesBuscados = repositorioCarrito.verTodosLosAdicionales();

        System.out.println("***************************************");
        for (int i = 0; i < adicionalesBuscados.size(); i++) {
            System.out.println("ADICIONAL: "+ adicionalesBuscados.get(i));
        }
        System.out.println("***************************************");

    }

    private void dadoQueExistenAdicionales() {

         ad1 = new Adicional(1L, "a", 100.00);
         ad2 = new Adicional(2L, "b", 100.00);

        session().save(ad1);
        session().save(ad2);

        carritoA1 = new CarritoAdicional(1L, ad1);
        carritoA2 = new CarritoAdicional(2L, ad2);

        session().save(carritoA1);
        session().save(carritoA2);
    }



    private void dadoQueExistenPlatos() {

        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", 2);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", 2);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", 2);
        plato4 = new Plato(4L, TipoPlato.VEGANO, "plato1", 4);
        session().save(plato1);
        session().save(plato2);
        session().save(plato3);
        session().save(plato4);


        List<Plato> platos = new LinkedList<>();

        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);

        carrito1 = new Carrito(1L, plato1);
        carrito2 = new Carrito(2L, plato2);
        carrito3 = new Carrito(3L, plato3);

        session().save(carrito1);
        session().save(carrito2);
        session().save(carrito3);

        Boolean result = repositorioCarrito.borrarPlato(1L);

//        Boolean guardado = repositorioCarrito.cargarAlCarrito(plato4);

    }


}
