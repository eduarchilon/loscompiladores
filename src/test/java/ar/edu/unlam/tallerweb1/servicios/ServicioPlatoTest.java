package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

import static ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato.VEGANO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioPlatoTest {

    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioCliente repositorioCliente;
    private RepositorioPlato repositorioPlato;
    private List<Plato> listaPlatos;
    private ServicioDetallePedido servicioDetallePedido;
    private PlatoService servicioPlato;
    private Plato plato1;
    private Plato plato2;


    @Before
    public void init() {
        repositorioCliente = mock(RepositorioCliente.class);
        repositorioDetallePedido = mock(RepositorioDetallePedido.class);
        repositorioPlato = mock(RepositorioPlato.class);
        servicioDetallePedido = new ServicioDetallePedidoImpl(repositorioDetallePedido, repositorioPlato, repositorioCliente);
        servicioPlato = new PlatoServiceImpl(repositorioPlato);
        listaPlatos = new LinkedList();
    }


    @Test
    public void queSePuedaEncontrarPlatosConAdicionales(){
        dadoQueExistanPlatosConAdicionales();

        when(servicioPlato.verPlatos()).thenReturn(listaPlatos);

        List <Plato> listaBuscada = servicioPlato.verPlatos();

        obtengoListaDePlatosConAdicionales(listaBuscada);

    }

    private void obtengoListaDePlatosConAdicionales(List<Plato> listaBuscada) {
        for (Plato plato : listaBuscada) {
            assertThat(plato.getAdicionales()).isNotEmpty();
        }
    }

    private void dadoQueExistanPlatosConAdicionales() {
        TipoGusto vegetariano = new TipoGusto(1L, "Vegetariano");
        Adicional ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        Adicional ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);
        List<Adicional> adicionales = new LinkedList();
        adicionales.add(ad1);
        adicionales.add(ad2);
        plato1 = new Plato(1L, vegetariano);
        plato2 = new Plato(2L, vegetariano);

        plato1.setAdicionales(adicionales);
        plato2.setAdicionales(adicionales);
        listaPlatos.add(plato1);
        listaPlatos.add(plato2);
    }


}
