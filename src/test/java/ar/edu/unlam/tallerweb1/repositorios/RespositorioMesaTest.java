package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorBusqueda;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;

public class RespositorioMesaTest extends SpringTest {

    @Autowired
    private RespositorioMesa respositorioMesa;

    Restaurante resto;
    Mesa mesa1;
    Mesa mesa2;
    Mesa mesa3;
    Mesa mesa4;
    Mesa mesa5;
    Mesa mesa6;

    @Before
    public void init(){
        resto = new Restaurante(1L, "La Bola de oro");
        mesa1 = new Mesa(1L, resto, 1, 4);
        mesa2 = new Mesa(2L, resto, 2, 3);
        mesa3 = new Mesa(3L, resto, 3, 2);
        mesa4 = new Mesa(4L, resto, 4, 5);
        mesa5 = new Mesa(5L, resto, 5, 4);
        mesa6 = new Mesa(6L, resto, 6, 3);
    }

    @Test
    @Transactional
    @Rollback
    public void queMuesteTodasLaMesasDelRestaurante(){
        dadoQueTengoUnaListaDeMesasDeUnRestaurante();

        List<Mesa> mesas = respositorioMesa.obetenerMesasDelRestaurante(resto.getId());

        assertThat(mesas.size()).isEqualTo(6);

    }

    private void dadoQueTengoUnaListaDeMesasDeUnRestaurante() {
        session().save(resto);
        session().save(mesa1);
        session().save(mesa2);
        session().save(mesa3);
        session().save(mesa4);
        session().save(mesa5);
        session().save(mesa6);
    }


}
