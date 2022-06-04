package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RepositorioRestauranteTest extends SpringTest {

    @Autowired
    private RepositorioRestaurante repositorioRestaurante;

    @Test @Transactional @Rollback
    public void buscarRestaurantePorNombre(){
        Restaurante resto1 = new Restaurante();
        resto1.setNombre("Lo de carlitos");
        session().save(resto1);

        Restaurante resto2 = new Restaurante();
        resto2.setNombre("El noble");
        session().save(resto2);

        Restaurante resto3 = new Restaurante();
        resto3.setNombre("Morita");
        session().save(resto3);

        List<Restaurante> resultado = repositorioRestaurante.buscarPorNombre("Morita");

        assertThat(resultado).hasSize(1);
    }

    @Test @Transactional @Rollback
    public void buscarRestaurantePorCalificacion(){
        Restaurante resto1 = new Restaurante();
        resto1.setNombre("Lo de carlitos");
        resto1.setCalificacion(5);
        session().save(resto1);

        Restaurante resto2 = new Restaurante();
        resto2.setNombre("El noble");
        resto2.setCalificacion(4);
        session().save(resto2);

        Restaurante resto3 = new Restaurante();
        resto3.setNombre("Morita");
        resto3.setCalificacion(4);
        session().save(resto3);

        List<Restaurante> resultado = repositorioRestaurante.buscarPorCalificacion(4);

        assertThat(resultado).hasSize(2);
    }
}
