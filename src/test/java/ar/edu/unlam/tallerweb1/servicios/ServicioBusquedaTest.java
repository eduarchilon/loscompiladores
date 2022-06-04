package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ServicioBusquedaTest {

    public static final String NOMBRE_VALIDO = "Milanesa";
    public static final String NOMBRE_INVALIDO = "Silla";

    private RepositorioPlato repositorioPlato;
    private RepositorioRestaurante repositorioRestaurante;
    private ServicioBusqueda servicioBusqueda;

    @Before
    public void init(){
        repositorioPlato = mock(RepositorioPlato.class);
        repositorioRestaurante = mock(RepositorioRestaurante.class);
        servicioBusqueda = new ServicioBusquedaImpl(repositorioPlato, repositorioRestaurante);
    }

    @Test
    public void siNoSeEncuentraPlatosConNombreSolicitadoDevuelvaListaVacia(){
        dadoQueNoExistanPlatosConNombre(NOMBRE_INVALIDO);

        List <Plato> platos = cuandoBuscoUnPlatoConNombre(NOMBRE_INVALIDO);

        obtengoUnaListaVacia(platos);

    }

    @Test
    public void siSeEncuentranPlatosBuscadosDevuelvaListaConPlatos(){
        dadoQueExistanPlatosConNombre(NOMBRE_VALIDO);

        List <Plato> platos = cuandoBuscoUnPlatoConNombre(NOMBRE_VALIDO);

        obtengoListaDePlatos(platos);
    }



    private void dadoQueExistanPlatosConNombre(String nombreValido) {
        List<Plato> lista = new LinkedList<>();
        for(int i = 0 ; i < 5; i++){
            lista.add(new Plato(nombreValido));
        }
        when(repositorioPlato.buscar(nombreValido)).thenReturn(lista);
    }

    private void dadoQueNoExistanPlatosConNombre(String nombreInvalido) {
        when(repositorioPlato.buscar(nombreInvalido)).thenReturn(new LinkedList());
    }


    private List<Plato> cuandoBuscoUnPlatoConNombre(String nombrePlato) {
        return servicioBusqueda.buscar(nombrePlato);
    }


    private void obtengoListaDePlatos(List<Plato> platos) {
        assertThat(platos).isNotEmpty();
    }

    private void obtengoUnaListaVacia(List<Plato> platos) {
        assertThat(platos).isEmpty();
    }



}
