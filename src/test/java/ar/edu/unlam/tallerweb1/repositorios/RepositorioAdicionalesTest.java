package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

public class RepositorioAdicionalesTest extends SpringTest {

    @Autowired
    private RepositorioAdicional repositorioAdicional;
    private List<Adicional> listaAdicionales;
    private TipoGusto vegetariano;
    private Adicional ad1;
    private Adicional ad2;

    @Before
    public void init() {

    }

    @Test @Rollback @Transactional
    public void queTraigaTodosLosAdicionales(){
        dadoQueExistenAdicionales();

        listaAdicionales = repositorioAdicional.getTodosLosAdicionales();

        assertThat(listaAdicionales.size()).isEqualTo(2);

    }

    private void dadoQueExistenAdicionales() {
        vegetariano = new TipoGusto(1L, "vegetariano");
        ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);

        session().save(vegetariano);
        session().save(ad1);
        session().save(ad2);

    }

}
