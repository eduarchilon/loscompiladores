package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioPedidoTest extends SpringTest {

    @Autowired
    private RepositorioPedido repositorioPedido;

    private Pedido pedido1;

    private Pedido pedido2;

    private Pedido pedido3;

    private Cliente ironMan;

    private Cliente hulk;

    private Plato plato1;
    private Plato plato2;
    private Plato plato3;

    @Before
    public void init() {

    }

    @Test @Transactional @Rollback
    public void queDevuelvaUnPedidoBuscado(){
        dadoQueExistenPedidos();

        Pedido buscado = repositorioPedido.buscarPedido(pedido3.getId());


        assertThat(buscado).isEqualTo(pedido1);
    }

    @Test @Transactional @Rollback
    public void queDevuelvaLosPedidosDeUnClinte(){
        /*Busco si el cliente tiene pedido*/
        dadoQueExistenPedidos();

        List<Pedido> pedidos = repositorioPedido.buscarPedidosCliente(ironMan);

        assertThat(pedidos.size()).isEqualTo(2);

    }

    @Test @Transactional @Rollback
    public void quedevuelvaLaListaDePlatosDeunPedido(){
        dadoQueExistenPedidos();

        System.out.println("***************************************");
        System.out.println("Cantidad de platos del pedido: " + pedido1.getListPlatos().size());
        System.out.println("***************************************");

        List<Pedido> pedidos = repositorioPedido.buscarPedidosCliente(ironMan);

        List<Plato> platos = (List<Plato>) repositorioPedido.verPlatosDelPedido(pedido1.getId());

        System.out.println("***************************************");
        System.out.println("Tamano: " + platos.size());
        for (int i = 0; i < platos.size(); i++) {
            System.out.println("NOMBRE PLATO: "+ platos.get(i));
        }
        System.out.println("***************************************");
//        List<Plato> platos = new LinkedList<>();
//
//        for (int i = 0; i <pedidos.size() ; i++) {
//            System.out.println("***************************************");
//            System.out.println("Pedido: " + pedidos.get(i).getListPlatos());
//            System.out.println("***************************************");
//            for (int j = 0; j < pedidos.get(i).getListPlatos().size(); j++) {
//                platos.add((Plato) pedidos.get(i).getListPlatos().get(j));
//            }
//        }
//        System.out.println("***************************************");
//        System.out.println("Platos: " + platos.size());
//        System.out.println("***************************************");
//        for (int i = 0; i < platos.size(); i++) {
//            System.out.println("Nombe Platos: " + platos.get(i).getId());
//            System.out.println("***************************************");
//        }

//        System.out.println("***************************************");
//        System.out.println(platos.size());
//        System.out.println("***************************************");

    }


    private void dadoQueExistenPedidos() {
        ironMan = new Cliente(1L , "Tony",  "Stark", "20145236", "116589542");
        hulk = new Cliente(2L , "Bruce",  "Banner", "20145236", "116589542");

        session().save(ironMan);
        session().save(hulk);

        plato1 = new Plato(1L, TipoPlato.VEGANO, "plato1", 2);
        plato2 = new Plato(2L, TipoPlato.VEGANO, "plato2", 2);
        plato3 = new Plato(3L, TipoPlato.VEGANO, "plato3", 2);

        session().save(plato1);
        session().save(plato2);
        session().save(plato3);

        List<Plato> platos = new LinkedList<>();

        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);

        pedido1 = new Pedido(1L, platos, ironMan);
//        pedido1.addPlato(plato1);
//        pedido1.addPlato(plato2);
//        pedido1.addPlato(plato3);

        pedido2 = new Pedido(2L, platos, hulk);
//        pedido2.addPlato(plato1);
//        pedido2.addPlato(plato2);
//        pedido2.addPlato(plato3);

        pedido3 = new Pedido(3L, platos, ironMan);
//        pedido3.addPlato(plato1);
//        pedido3.addPlato(plato2);
//        pedido3.addPlato(plato3);


        session().save(pedido1);
        session().save(pedido2);
        session().save(pedido3);

    }


}