package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAdicional;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioAdicionalTest {

    private RepositorioAdicional repositorioAdicional;
    private ServicioAdicional servicioAdicional;
    private List<Adicional> adicionales;
    private TipoGusto vegetariano;
    private TipoGusto arabe;
    private Adicional ad1;
    private Adicional ad2;
    private Adicional ad3;

    @Before
    public void init() {
        repositorioAdicional = mock(RepositorioAdicional.class);
        servicioAdicional = new ServicioAdicionalImpl(repositorioAdicional);
    }

    @Test
    public void queTraigaLosAdicionalesDeTipoGustoElegido(){
        dadoQueExistanAdicionales();

        when(servicioAdicional.getAdicionales()).thenReturn(adicionales);

        List<Adicional> adicionalesPorGusto = servicioAdicional.getAdicionalesPorGusto(arabe);

        assertThat(adicionalesPorGusto).hasSize(1);
    }

    @Test
    public void queSumeElPrecioDeLosAdicionalesPorGustoElegido(){
        dadoQueExistanAdicionales();

        when(servicioAdicional.getAdicionales()).thenReturn(adicionales);

        List<Adicional> adicionalesPorGusto = servicioAdicional.getAdicionalesPorGusto(vegetariano);

        Double precioTotal = servicioAdicional.calcularTodosLosAdicionalesPorGusto(vegetariano);

        assertThat(precioTotal).isEqualTo(350.00);
    }


    private void dadoQueExistanAdicionales() {
        vegetariano = new TipoGusto(1L, "Vegetariano");
        arabe = new TipoGusto(2L, "Arabe");
        ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);
        ad3 = new Adicional(2L, "Pan arabe", 150.00, arabe);
        adicionales = new LinkedList();
        adicionales.add(ad1);
        adicionales.add(ad2);
        adicionales.add(ad3);
    }


}
