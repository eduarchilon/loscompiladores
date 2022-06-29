package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.hibernate.SessionFactory;

import java.util.List;

public interface RepositorioPedido {

    Pedido buscarPedido(Long id);

    Pedido buscarPedidoPorid(Long id);

    List<Pedido> buscarPedidosCliente(Cliente id);

    List<Pedido> verPedidos();

    List<Plato> verPlatosDelPedido(Long pedido);


    void realizarPedido(List<Plato> listaPlatos, Cliente cliente);

}
