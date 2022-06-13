package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{


    private RepositorioPedido repositorioPedido;

    @Autowired
    public PedidoServiceImpl (RepositorioPedido repositorioPedido){
        this.repositorioPedido = repositorioPedido;
    }

    @Override
    public List<Pedido> verPedidosClientes(Cliente cliente){
        List<Pedido> pedidos = repositorioPedido.buscarPedidosCliente(cliente);
        return pedidos;
    }

    @Override
    public List<Pedido> verTodosLosPedidos() {
        return repositorioPedido.verPedidos();
    }

    @Override
    public List<Plato> verPlatosDelPedido(Long pedido) {
        List<Plato> platos =repositorioPedido.verPlatosDelPedido(pedido);
        return platos;
    }


}
