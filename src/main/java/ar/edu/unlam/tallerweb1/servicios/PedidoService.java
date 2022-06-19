package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PedidoService {

    List<Pedido> verPedidosClientes(Cliente cliente);

    List<Pedido> verTodosLosPedidos();

    List<Plato> verPlatosDelPedido(Long pedido);

    void realizarPedido(HttpServletRequest request);

    Pedido verPedido(Pedido pedido);

    Pedido buscarPedidoPorId(Long pedido);

    List<Plato> verPlatosDelPedido(Pedido pedido);


}
