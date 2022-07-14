package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositorioRestauranteTest extends SpringTest {

    private Plato plato1;
    private Plato plato2;
    private Plato plato3;
    private Plato plato4;
    private Plato plato5;
    private Plato plato6;

    @Autowired
    private RepositorioRestaurante repositorioRestaurante;

    @Test @Transactional @Rollback
    public void buscarRestaurantePorNombre(){
        Restaurante resto1 = new Restaurante(1L, 9, 23);
        resto1.setNombre("Lo de carlitos");
        session().save(resto1);

        Restaurante resto2 = new Restaurante(1L, 9, 23);
        resto2.setNombre("El noble");
        session().save(resto2);

        Restaurante resto3 = new Restaurante(1L, 9, 23);
        resto3.setNombre("Morita");
        session().save(resto3);

        List<Restaurante> resultado = repositorioRestaurante.buscarPorNombre("Morita");

        assertThat(resultado).hasSize(1);
    }

    @Test @Transactional @Rollback
    public void buscarRestaurantePorCalificacion(){
        Restaurante resto1 = new Restaurante(1L, 9, 23);
        resto1.setNombre("Lo de carlitos");
        resto1.setCalificacion(5);
        session().save(resto1);

        Restaurante resto2 = new Restaurante(1L, 9, 23);
        resto2.setNombre("El noble");
        resto2.setCalificacion(4);
        session().save(resto2);

        Restaurante resto3 = new Restaurante(1L, 9, 23);
        resto3.setNombre("Morita");
        resto3.setCalificacion(4);
        session().save(resto3);

        List<Restaurante> resultado = repositorioRestaurante.buscarPorCalificacion(4);

        assertThat(resultado).hasSize(2);
    }

    @Test @Transactional @Rollback
    public void quemuestreTodosLosRestaurantes(){
        Restaurante resto1 = new Restaurante(1L, 9, 23);
        resto1.setNombre("Lo de carlitos");
        resto1.setCalificacion(5);
        session().save(resto1);

        Restaurante resto2 = new Restaurante(1L, 9, 23);
        resto2.setNombre("El noble");
        resto2.setCalificacion(4);
        session().save(resto2);

        Restaurante resto3 = new Restaurante(1L, 9, 23);
        resto3.setNombre("Morita");
        resto3.setCalificacion(4);
        session().save(resto3);

        List<Restaurante> lista = repositorioRestaurante.verTodosLosRestaurantes();

        System.out.println("***********************");
        for (int i = 0; i < lista.size() ; i++) {
            System.out.println("Restaurante-" + lista.get(i).getId() + ": " + lista.get(i).getNombre());
        }
        System.out.println("***********************");
    }

    @Test @Transactional @Rollback
    public void quemuestreLosPlatosDelRestaurante(){

        Restaurante restoA = new Restaurante(1L, "Resto1");
        Restaurante restoB = new Restaurante(2L, "Resto2");

        session().save(restoA);
        session().save(restoB);

        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", restoA);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", restoA);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", restoB);
        plato4 = new Plato(4L, TipoPlato.VEGANO, "plato4", restoB);
        plato5 = new Plato(5L, TipoPlato.VEGANO, "plato5", restoA);
        plato6 = new Plato(6L, TipoPlato.VEGANO, "plato6", restoB);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);
        session().save(plato4);
        session().save(plato5);
        session().save(plato6);

//        Restaurante restoBuscado = (Restaurante) repositorioRestaurante.verRestaurante(1L);
//
//        System.out.println("***********************");
//        System.out.println(restoBuscado.getNombre());
//        System.out.println("***********************");


        List<Plato> platos = (List<Plato>)repositorioRestaurante.verPlatosDelRestaurante(1L);

        System.out.println("***********************");
        for (int i = 0; i < platos.size() ; i++) {
            System.out.println(platos.get(i).getDescripcion());
        }
        System.out.println("***********************");

    }

    @Test @Transactional @Rollback
    public void queBusqueResturantesPorLocalidad(){
        dadoQueTengoResturantesConLocalidad();

        /*La localidad 2L es la localidad Moron*/
        List<Restaurante> resturantesDeLocalidad = repositorioRestaurante.buscarRestuarntesPorLocalidad(2L);

        assertThat(resturantesDeLocalidad.size()).isEqualTo(1);
    }

    private void dadoQueTengoResturantesConLocalidad() {
        Localidad localidad1 = new Localidad(1L, "Ciudadela");
        Localidad localidad2 = new Localidad(2L, "Moron");
        session().save(localidad1);
        session().save(localidad2);

        Restaurante resto1 = new Restaurante(1L, localidad1);
        resto1.setNombre("Uno");
        session().save(resto1);

        Restaurante resto2 = new Restaurante(2L, localidad2);
        resto2.setNombre("Dos");
        session().save(resto2);

        Restaurante resto3 = new Restaurante(3L, localidad1);
        resto3.setNombre("Tres");
        session().save(resto3);
    }
}
