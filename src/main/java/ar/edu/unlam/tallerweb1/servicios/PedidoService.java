package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> verPedidosClientes(Cliente cliente);

    List<Pedido> verTodosLosPedidos();

}
