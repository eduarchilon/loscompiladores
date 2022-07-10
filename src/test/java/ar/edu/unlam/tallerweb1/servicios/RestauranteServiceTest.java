package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
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

    private Plato plato1;
    private Plato plato2;
    private Plato plato3;
    private Plato plato4;
    private Plato plato5;
    private Plato plato6;

    List<Restaurante> listaRestos;

    @Before
    public void init(){
        repositorioRestaurante = mock(RepositorioRestaurante.class);
        restauranteService = new RestauranteServiceImpl(repositorioRestaurante);
    }

    @Test
    public void queMuestreLaLocalidadDeLosResturantes(){
        dadoQueTengoRestaurantesConLocalidad();

        Localidad localidad = new Localidad(1L, "Ciudadela");
        List<Restaurante> listaRestos = new LinkedList<>();

        cuandoBuscoLosLocalesConRestos(localidad, listaRestos);

        List<Restaurante> buscado = restauranteService.buscarPorLocalidad(localidad.getId());

        System.out.println("-------------------------------");
        for (int i = 0; i <buscado.size() ; i++) {
            System.out.println(buscado.get(i).getNombre());
        }
        System.out.println("-------------------------------");

    }

    private void cuandoBuscoLosLocalesConRestos(Localidad localidad, List<Restaurante> listaRestos) {
        listaRestos.add(resto1);
        listaRestos.add(resto2);
        listaRestos.add(resto3);
//        when(repositorioRestaurante.verTodosLosRestaurantes()).thenReturn(listaRestos);
        when(restauranteService.buscarPorLocalidad(localidad.getId())).thenReturn(listaRestos);
    }

    private void dadoQueTengoRestaurantesConLocalidad() {
        Localidad localidad1 = new Localidad(1L, "Ciudadela");
        Localidad localidad2 = new Localidad(2L, "Moron");

        resto1 = new Restaurante(1L, localidad1);
        resto1.setNombre("Uno");

        resto2 = new Restaurante(2L, localidad2);
        resto2.setNombre("Dos");

        resto3 = new Restaurante(3L, localidad1);
        resto3.setNombre("Tres");
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

    @Test
    public void queMuestreLosPlatosDelRestauranteEnServicio(){
        Restaurante restoA = new Restaurante(1L, "Resto1");
        Restaurante restoB = new Restaurante(2L, "Resto2");


        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", restoA);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", restoA);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", restoA);
        plato4 = new Plato(4L, TipoPlato.VEGANO, "plato4", restoA);
        plato5 = new Plato(5L, TipoPlato.VEGANO, "plato5", restoA);
        plato6 = new Plato(6L, TipoPlato.VEGANO, "plato6", restoA);

        List<Plato> platos = new LinkedList<>();
        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);
        platos.add(plato4);
        platos.add(plato5);
        platos.add(plato6);

        cuandoBuscoAlRestaurante(restoA, platos);

        List<Plato> listaPlatos = (List<Plato>) restauranteService.verPlatosDelRestaurante(1L);

        System.out.println("***********************");
        System.out.println(listaPlatos.size());
        System.out.println("***********************");




    }

    private void cuandoBuscoAlRestaurante(Restaurante restaurante, List<Plato> platos) {
        /*Al mockear no importa el resturante que le asigne al plato ya que le di al servicio la lista*/
        when(restauranteService.verPlatosDelRestaurante(restaurante.getId())).thenReturn(platos);
    }

    private void tengoLaListaDeRestaurtantes(List<Restaurante> lista) {
        when(restauranteService.verTodosLosRestaurantes()).thenReturn(lista);
    }

    private void dadoQueExistenRestaurantes() {

        resto1 = new Restaurante(1L, 9, 23);
        resto1.setNombre("Lo de carlitos");
        resto1.setCalificacion(5);;

        resto2 = new Restaurante(1L, 9, 23);
        resto2.setNombre("El noble");
        resto2.setCalificacion(4);

        resto3 = new Restaurante(1L, 9, 23);
        resto3.setNombre("Morita");
        resto3.setCalificacion(3);
    }


}
