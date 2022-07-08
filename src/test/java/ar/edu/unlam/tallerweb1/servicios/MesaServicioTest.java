package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import ar.edu.unlam.tallerweb1.repositorios.RespositorioMesa;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MesaServicioTest {

    private RespositorioMesa respositorioMesa;
    private MesaService mesaService;

    Restaurante resto;
    Mesa mesa1;
    Mesa mesa2;
    Mesa mesa3;
    Mesa mesa4;
    Mesa mesa5;
    Mesa mesa6;
    List<Mesa> mesas = new LinkedList<>();

    @Before
    public void init(){
        respositorioMesa = mock(RespositorioMesa.class);
        mesaService = new MesaServiceImpl(respositorioMesa);

        resto = new Restaurante(1L, "La Bola de oro");
        mesa1 = new Mesa(1L, resto, 1, 4);
        mesa2 = new Mesa(2L, resto, 2, 3);
        mesa3 = new Mesa(3L, resto, 3, 2);
        mesa4 = new Mesa(4L, resto, 4, 5);
        mesa5 = new Mesa(5L, resto, 5, 4);
        mesa6 = new Mesa(6L, resto, 6, 3);

        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);
        mesas.add(mesa4);
        mesas.add(mesa5);
        mesas.add(mesa6);

    }

    @Test
    public void quemuestreTodasLasMesasDelResto(){
            dadoQueExistanMesasEnElResto(resto.getId(), mesas);
    }

    private void dadoQueExistanMesasEnElResto(Long idRestro, List<Mesa> mesas) {
        when(mesaService.getMesasDelRestaurante(idRestro)).thenReturn(mesas);
    }


}
