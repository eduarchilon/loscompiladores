package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoGusto;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTipoGustoTest {

    private RepositorioTipoGusto repositorioTipoGusto;
    private ServicioTipoGusto servicioTipoGusto;
    private List<TipoGusto> listaGustos;
    private List<Plato> listaPlatos;
    private TipoGusto vegetariano;
    private TipoGusto arabe;
    private Plato plato1;
    private Plato plato2;

    @Before
    public void init(){
        repositorioTipoGusto = mock(RepositorioTipoGusto.class);
        servicioTipoGusto = new ServicioTipoGustoImpl(repositorioTipoGusto);
    }

    @Test
    public void queTraigaTodosLosGustos(){
        dadoQueExistenGustos();

        /*el mock finge una dependencia de la implementacion. Es como el autowired en el constructor*/
        /*con el when es como si se le instanciara todos los objetos en el metodo*/
        when(servicioTipoGusto.verTodosLosGustos()).thenReturn(listaGustos);

        List <TipoGusto> listaBuscada = servicioTipoGusto.verTodosLosGustos();

        assertThat(listaBuscada.size()).isEqualTo(2);

    }

    @Test
    public void queTraigaPlatosSegunGusto(){
        dadoQueExistenGustos();

        when(servicioTipoGusto.verPlatosPorGusto(1L)).thenReturn(listaPlatos);

        List<Plato> listaBuscada = servicioTipoGusto.verPlatosPorGusto(1L);

        assertThat(listaBuscada.size()).isEqualTo(2);
    }




    private void dadoQueExistenGustos() {
        vegetariano = new TipoGusto(1L, "vegetariano");
        arabe = new TipoGusto(2L, "arabe");
        listaGustos = new LinkedList();
        listaGustos.add(arabe);
        listaGustos.add(vegetariano);

        plato1 = new Plato(1L, vegetariano);
        plato2 = new Plato(2L, vegetariano);
        listaPlatos = new LinkedList();
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);

    }


}
