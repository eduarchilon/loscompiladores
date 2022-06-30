package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RestauranteTest extends SpringTest {

    private Restaurante resto1;

    @Before
    public void init(){
        resto1 = new Restaurante();
    }

    @Test @Transactional @Rollback
    public void queSePuedaCrearUnRestaurante(){
        resto1.setNombre("Lo de Pepe");
        resto1.setDireccion("Bolivar 542");
        resto1.setCalificacion(4);
        resto1.setHorario("09:00 a 20:00");
        resto1.setTelefono("4578-3254");
        resto1.setNumeroDeMesas(15);
        session().save(resto1);
        assertThat(resto1.getId()).isNotNull();
    }

    @Test @Transactional @Rollback()
    public void modificaUnRestauranteYLaBuscaPorDireccion(){
        Restaurante resto = new Restaurante();
        resto.setNombre("Lo de Jaime");
        resto.setDireccion("Del rio 1542");
        final Session session = session();
        session.save(resto);
        resto.setDireccion("Costa Rica 5524");

        session.update(resto);

        Restaurante buscado = session.get(Restaurante.class, resto.getId());
        assertThat(buscado.getDireccion()).isEqualTo("Costa Rica 5524");
    }

}
