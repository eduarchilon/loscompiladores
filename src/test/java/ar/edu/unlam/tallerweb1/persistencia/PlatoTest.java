package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class PlatoTest extends SpringTest {




    @Test @Transactional @Rollback
    public void queSePuedaCrearUnPlato(){
        Plato plato1 = new Plato();
        plato1.setNombre("Chocotorta vegana");
        plato1.setDescripcion("Porcion de chocotorta, con coco y nutella");
        plato1.setPrecio(860.00);
        plato1.setTIPO_PLATO(TipoPlato.VEGANO);
        session().save(plato1);
        assertThat(plato1.getId()).isNotNull();
    }

    @Test @Transactional @Rollback
    public void queSePuedaEliminarUnPlato(){
        Plato plato1 = new Plato();
        session().delete(plato1);
        assertThat(plato1.getId()).isNull();
    }



}
