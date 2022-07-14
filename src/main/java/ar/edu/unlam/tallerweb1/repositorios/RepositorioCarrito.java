package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.CarritoAdicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;

import java.util.List;

public interface RepositorioCarrito {

    List<Plato> verTodosLoaPlatos(Long idCarrito);

    Plato detalleDelPlato(Long idPlato);

    List<Restaurante> verTodosLosRestaurantesDelCarrito(Long idCarrito);

    Restaurante detalleDelResturante(Long idRestaurante);

    Carrito verCarrito(Long idCarrito);

    /*Nuevo*/
    List<Carrito> verTodosLosPlatos();

    Boolean borrarPlato(Long idPlatoCarrito);

    void cargarAlCarrito(Long plato);

    List<CarritoAdicional> verTodosLosAdicionales();

    Boolean borrarAdicional(Long idCarritoAdicional);

    void cargarAlCarritoAdicional(Long idCarritoAdicional);
}
