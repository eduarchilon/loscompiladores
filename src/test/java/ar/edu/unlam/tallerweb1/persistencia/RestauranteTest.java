package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
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

}
