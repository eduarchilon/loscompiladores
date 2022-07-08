package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface CarritoService {

    Carrito verPlatosDelCarrito(Long idCarrito);

    List<Carrito> verListDePlatosDelCarrito();

    Boolean borrarPlatoDelCarrito(Long idPlatoCarrito);

    void agregarPlatoAlCarrito(Long plato);

    Double getSubtotal(List<Carrito> platos);

    Double getTotal(Double subtotal, Double descuento);
}
