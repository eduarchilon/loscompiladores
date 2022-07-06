package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
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

//    @Test
//    @Transactional
//    @Rollback
//    public void queMeMuestreLosPlatosDelCarrito(){
//
//        dadoQueExistenPlatos();
//
//        List<Plato> listaPlatosDelCarrito = (List<Plato>)repositorioCarrito.verTodosLoaPlatos(carrito.getId());
//
//        assertThat(listaPlatosDelCarrito).hasSize(3);
//
//        System.out.println("***************************************");
//        System.out.println("Tamano: " + listaPlatosDelCarrito.size());
//        System.out.println("NOMBRE PLATO: "+plato1.getId());
//        System.out.println("NOMBRE PLATO: "+ plato2.getId());
//
//        for (int i = 0; i < listaPlatosDelCarrito.size(); i++) {
//            System.out.println("NOMBRE PLATO: "+ listaPlatosDelCarrito.get(i));
//        }
//        System.out.println("***************************************");
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void queMuestreElCarrito(){
//
//        dadoQueExistenPlatos();
//
//        Carrito buscado = (Carrito)repositorioCarrito.verCarrito(carrito.getId());
//
//        System.out.println("***************************************");
//        System.out.println("Carrito: " + buscado.getId());
//        for (int i = 0; i < buscado.getPlatos().size(); i++) {
//            System.out.println("NOMBRE PLATO: "+ buscado.getPlatos().get(i).getId());
//        }
//        System.out.println("***************************************");
//
//    }


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
