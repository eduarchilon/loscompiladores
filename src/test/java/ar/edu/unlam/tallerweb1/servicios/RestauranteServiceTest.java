package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

public class RestauranteServiceTest {

    private RepositorioRestaurante repositorioRestaurante;
    private RestauranteService restauranteService;

    private Restaurante resto1;
    private Restaurante resto2;
    private Restaurante resto3;

    @Before
    public void init(){
        repositorioRestaurante = mock(RepositorioRestaurante.class);
        restauranteService = new RestauranteServiceImpl(repositorioRestaurante);
    }

    @Test
    public void queMuestreLosRestaurantesMasValorados(){

        dadoQueExistenRestaurantes();

        List<Restaurante> lista = new LinkedList<>();
        lista.add(resto1);
        lista.add(resto2);
        lista.add(resto3);

        tengoLaListaDeRestaurtantes(lista);

        List<Restaurante> valorados = restauranteService.getRestaurantesMasCalificados();

        assertThat(valorados.size()).isEqualTo(2);

        System.out.println("***************************************");
        for (int i = 0; i < valorados.size() ; i++) {
            System.out.println("Resto: " + valorados.get(i).getNombre() + " - Calificacion: " + valorados.get(i).getCalificacion());
        }
        System.out.println("***************************************");

    }

    private void tengoLaListaDeRestaurtantes(List<Restaurante> lista) {
        when(restauranteService.verTodosLosRestaurantes()).thenReturn(lista);
    }

    private void dadoQueExistenRestaurantes() {

        resto1 = new Restaurante();
        resto1.setNombre("Lo de carlitos");
        resto1.setCalificacion(5);;

        resto2 = new Restaurante();
        resto2.setNombre("El noble");
        resto2.setCalificacion(4);

        resto3 = new Restaurante();
        resto3.setNombre("Morita");
        resto3.setCalificacion(3);
    }

}
