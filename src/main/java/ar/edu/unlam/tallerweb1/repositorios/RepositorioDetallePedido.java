package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface RepositorioDetallePedido {

    void agregarPlatoAlDetallePedido(Plato plato, Cliente cliente);

    List<DetallePedido> buscarPorIdCliente(Cliente cliente);

    void eliminarPlatoDelDetallePedido(Plato plato, Cliente cliente);

    DetallePedido buscarDetallePedido(Plato plato, Cliente cliente);
}
