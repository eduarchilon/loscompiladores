package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

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

    @Test @Transactional @Rollback
    public void modificaUnPlatoYLaBuscaPorNombrePlato(){
        Plato plato = new Plato();
        plato.setNombre("arroz");
        plato.setPrecio(60.00);
        final Session session = session();
        session.save(plato);
        plato.setPrecio(100.00);

        session.update(plato);

        Plato buscado = session.get(Plato.class, plato.getId());
        assertThat(buscado.getPrecio()).isEqualTo(100.00);
    }

    @Test @Transactional @Rollback
    public void queSePuedaAgregarUnAdicionalAlPlato(){
        final Session session = session();
        TipoGusto vegetariano = new TipoGusto(1L, "Vegetariano");
        Adicional ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        Adicional ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);
        List<Adicional> adicionales = new LinkedList();
        adicionales.add(ad1);
        adicionales.add(ad2);

        Plato plato = new Plato();
        plato.setNombre("arroz");
        plato.setAdicionales(adicionales);
        session.save(plato);

        Plato buscado = session.get(Plato.class, plato.getId());
        assertThat(buscado.getAdicionales()).isNotEmpty();
    }



}
