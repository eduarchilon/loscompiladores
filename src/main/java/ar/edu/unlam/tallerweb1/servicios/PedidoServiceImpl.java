package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPedido;
import org.springframework.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioPedido repositorioPedido;
    private RepositorioCliente repositorioCliente;

    @Autowired
    public PedidoServiceImpl (RepositorioPedido repositorioPedido, RepositorioDetallePedido repositorioDetallePedido, RepositorioCliente repositorioCliente){
        this.repositorioPedido = repositorioPedido;
        this.repositorioDetallePedido = repositorioDetallePedido;
        this.repositorioCliente = repositorioCliente;
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
        Pedido pedidoBuscado =repositorioPedido.buscarPedido(pedido);
        return pedidoBuscado.getListPlatos();
    }

    @Override
    public void realizarPedido(HttpServletRequest request) {
        Long idCliente = Long.valueOf(request.getParameter("idCliente"));
        Cliente clienteEncontrado = repositorioCliente.buscarPorId(idCliente);
        List<DetallePedido> listaDetalles = repositorioDetallePedido.buscarPorIdCliente(clienteEncontrado);

        List<Plato> listaPlatos = new LinkedList();
        for(DetallePedido detalle : listaDetalles){
            listaPlatos.add(detalle.getPlato());
        }

        for(Plato plato : listaPlatos){
            Integer cantVentas = plato.getCantVentas();
            if(cantVentas.equals(null)){
                cantVentas = 0;
            }
            plato.setCantVentas(++cantVentas);
        }


        repositorioPedido.realizarPedido(listaPlatos, clienteEncontrado);
    }

    @Override
    public Pedido verPedido(Pedido pedido) {
        return repositorioPedido.buscarPedido(pedido.getId());
    }

    @Override
    public Pedido buscarPedidoPorId(Long pedido) {
        return repositorioPedido.buscarPedido(pedido);
    }

    @Override
    public List<Plato> verPlatosDelPedido(Pedido pedido) {
        Pedido pedidoBuscado = verPedido(pedido);
        return pedidoBuscado.getListPlatos();
    }


}
