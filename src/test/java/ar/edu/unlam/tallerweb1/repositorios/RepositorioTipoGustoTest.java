package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;


public class RepositorioTipoGustoTest extends SpringTest {

    @Autowired
    private RepositorioTipoGusto repositorioTipoGusto;
    private List<TipoGusto> listaGustos;
    private List<Plato> listaBuscada;
    private TipoGusto vegetariano;
    private TipoGusto arabe;
    private Plato plato1;
    private Plato plato2;

    @Before
    public void init() {

    }

    @Test @Rollback @Transactional
    public void queTraigaTodosLosGustos(){
        dadoQueExistenGustos();

        listaGustos = repositorioTipoGusto.getTodosLosGustos();

        assertThat(listaGustos.size()).isEqualTo(2);

    }

    @Test @Rollback @Transactional
    public void queBusquePlatosPorGustos(){
        dadoQueExistenGustos();

        listaBuscada = repositorioTipoGusto.getPlatosPorGusto(1L);

        assertThat(listaBuscada.size()).isEqualTo(2);

    }



    private void dadoQueExistenGustos() {
        vegetariano = new TipoGusto(1L, "vegetariano");
        arabe = new TipoGusto(2L, "arabe");
        session().save(vegetariano);
        session().save(arabe);
        plato1 = new Plato(1L, vegetariano);
        plato2 = new Plato(2L, vegetariano);
        session().save(plato1);
        session().save(plato2);
    }


}
