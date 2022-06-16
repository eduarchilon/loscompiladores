package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServicioDetallePedido {

    void agregarPlatoAlDetallePedido(HttpServletRequest request);

    Plato buscarPlato(HttpServletRequest request);

    List<DetallePedido> buscarPorIdCliente(HttpServletRequest request);

    void eliminarPlatoDelDetallePedido(HttpServletRequest request);
}
