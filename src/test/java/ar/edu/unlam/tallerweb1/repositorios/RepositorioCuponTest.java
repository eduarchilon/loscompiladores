package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cupon;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioCuponTest extends SpringTest {

    @Autowired
    private RepositorioCupon repositorioCupon;

    private Cupon cupon1;
    private Cupon cupon2;
    private Cupon cupon3;
    private Cupon cupon4;
    private String CUPON_TUENTI = "TUENTI";


    @Test
    @Transactional
    @Rollback
    public void queBusqueUnCuponYverSuContendio(){

    dadoQueExistenCupones();

    Cupon cupon = repositorioCupon.buscarCuponPorNombre(CUPON_TUENTI);

    assertThat(cupon.getDescuento()).isEqualTo(10);
    System.out.println(cupon.getNombre());
    }

    private void dadoQueExistenCupones() {

        cupon1 = new Cupon(1L, "TUENTI", 10);
        cupon2 = new Cupon(2L, "MOVISTAR", 20);
        cupon3 = new Cupon(3L, "PERSONAL", 30);
        cupon4 = new Cupon(4L, "CLARO", 40);

        session().save(cupon1);
        session().save(cupon2);
        session().save(cupon3);
        session().save(cupon4);
    }
}
