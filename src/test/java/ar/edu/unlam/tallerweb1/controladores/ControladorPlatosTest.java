package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorPlatos;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import ar.edu.unlam.tallerweb1.servicios.PlatoService;
import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorPlatosTest{

//    private ControladorPlatos controladorPlatos;
//    private PlatoService platoService;

//    @Before
//    public void init(){
//        //creo una instancia falsa de la implementacion
//        platoService = mock(PlatoService.class);
//        controladorPlatos = new ControladorPlatos(platoService);
//
//    }

    @Test
    public void queMuestreTodosLosPlatos(){

//        /*Preparacion*/
//        List<Plato> platos = new LinkedList<>();
//        Plato plato1 = new Plato(1L, TipoPlato.VEGANO, "Solo verduras");
//        Plato plato2 = new Plato(2L, TipoPlato.VEGETARIANO, "verduras y huevo");
//        Plato plato3 = new Plato(3L, TipoPlato.TIPICA, "Milanesa y pure de papa");
//        platos.add(plato1);
//        platos.add(plato2);
//        platos.add(plato3);
//
//        assertThat(platos.size()).isEqualTo(3);

    }

}