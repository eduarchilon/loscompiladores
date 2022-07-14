package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato.VEGANO;
import static org.assertj.core.api.Assertions.*;

public class RepositorioPlatoTest extends SpringTest{

    public static final String NOMBRE_VALIDO = "Milanesa";
    public static final Double PRECIO_VALIDO = 1000.00;
    public static final String NOMBRE_INVALIDO = "Silla";

    @Autowired
    private RepositorioPlato repositorioPlato;

    @Before
    public void init() {

    }

    @Test @Transactional @Rollback
    public void devuelvePlatosQueCoincidanConElNombreIndicado(){
        dadoQueExistanPlatosConNombre();
        List<Plato> platos = repositorioPlato.buscar(NOMBRE_VALIDO);

        entoncesPlatosEncontrados(platos);
    }

    @Test @Transactional @Rollback
    public void siNoHayCoincidenciasDevuelveListaVacia(){

        List<Plato> platos = repositorioPlato.buscar(NOMBRE_INVALIDO);

        entoncesNoEncuentroPlatos(platos);
    }

    @Test @Transactional @Rollback
    public void devuelvePlatosQueCoincidanConElPrecioIndicado(){

        List<Plato> platos = repositorioPlato.buscar(750.00);

        entoncesPlatosEncontrados(platos);
    }

    @Test @Transactional @Rollback
    public void siTraeListaPlatosMasVendidos(){
        List<Plato> platos = repositorioPlato.platosMasVendidos();
        entoncesNoTraePlatos(platos);

    }

    @Test @Transactional @Rollback
    public void devuelvePlatoConAdicionales(){
        dadoQueExistanPlatosConNombreYAdicionales();
       List<Plato> platoEncontrado = repositorioPlato.buscar(NOMBRE_VALIDO);
        entoncesEncuentroPlatoConAdicionales(platoEncontrado);
    }

    private void dadoQueExistanPlatosConNombreYAdicionales() {
        Plato plato1 = new Plato(VEGANO,"Milanesa con pure",1);
        Plato plato2 = new Plato(VEGANO,"Milanesa con papas fritas",2);
        Plato plato3 = new Plato(VEGANO,"Milanesa de berenjena con pure",3);
        Plato plato4 = new Plato(VEGANO,"Arroz al wok con verduras",10);
        TipoGusto vegetariano = new TipoGusto(1L, "Vegetariano");
        Adicional ad1 = new Adicional(1L, "Pan integral", 200.00, vegetariano);
        Adicional ad2 = new Adicional(2L, "Agua", 150.00, vegetariano);
        List<Adicional> adicionales = new LinkedList();
        adicionales.add(ad1);
        adicionales.add(ad2);
        plato1.setAdicionales(adicionales);
        plato2.setAdicionales(adicionales);
        plato3.setAdicionales(adicionales);
        plato4.setAdicionales(adicionales);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);
        session().save(plato4);
    }

    private void entoncesEncuentroPlatoConAdicionales(List<Plato> platoEncontrado) {
        for (Plato plato : platoEncontrado) {
            assertThat(plato.getAdicionales()).isNotEmpty();
        }
    }


    private void dadoQueExistanPlatosConNombre() {
        Plato plato1 = new Plato(VEGANO,"Milanesa con pure",1);
        Plato plato2 = new Plato(VEGANO,"Milanesa con papas fritas",2);
        Plato plato3 = new Plato(VEGANO,"Milanesa de berenjena con pure",3);
        Plato plato4 = new Plato(VEGANO,"Arroz al wok con verduras",10);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);
        session().save(plato4);
    }

    @Test @Transactional @Rollback
    public void buscarUnPlato(){

        Plato plato1 = new Plato(1L,VEGANO,"Milanesa con pure",1);
        Plato plato2 = new Plato(2L, VEGANO,"Milanesa con papas fritas",2);
        Plato plato3 = new Plato(3L, VEGANO,"Milanesa de berenjena con pure",3);
        Plato plato4 = new Plato(4L, VEGANO,"Arroz al wok con verduras",10);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);
        session().save(plato4);

        List<Plato> platos = repositorioPlato.buscarTodos();

        Plato platoBuscado = repositorioPlato.buscarPlato(1L);

        assertThat(platoBuscado.getId()).isEqualTo(1L);
    }


    @Test @Transactional @Rollback
    public void queAgregueAdicionalesAlPlato(){
        Adicional a = new Adicional(1L, "a", 200.0);
        Adicional b = new Adicional(2L, "b", 200.0);
        Adicional c = new Adicional(3L, "c", 200.0);

        session().save(a);
        session().save(b);
        session().save(c);

        Plato plato1 = new Plato(1L,VEGANO,"Milanesa con pure",1);

        session().save(plato1);

        Boolean resultado = (Boolean) repositorioPlato.agregarAdicionalAlPlato(1L, 1L);
        Boolean resultadoA = (Boolean) repositorioPlato.agregarAdicionalAlPlato(2L, 1L);

        assertThat(resultado).isTrue();
//        System.out.println(plato1.getAdicionales().get(0).getNombre());
//        System.out.println(plato1.getAdicionales().get(1).getNombre());

        for (int i = 0; i <plato1.getAdicionales().size() ; i++) {
            System.out.println(plato1.getAdicionales().get(i).getNombre());
        }

    }


    private void entoncesPlatosEncontrados(List<Plato> platos) {
        assertThat(platos).isNotEmpty();
    }

    private void  entoncesNoTraePlatos(List<Plato> platos) { assertThat(platos).isEmpty();}

    private void entoncesNoEncuentroPlatos(List<Plato> platos) {
        assertThat(platos).hasSize(0);
    }




}
