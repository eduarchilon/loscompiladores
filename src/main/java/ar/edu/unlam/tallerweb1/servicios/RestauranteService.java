package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;

import java.util.List;

public interface RestauranteService {

    List<Restaurante> getRestaurantesMasCalificados();

    List<Restaurante> verTodosLosRestaurantes();

    List<Plato> verPlatosDelRestaurante(Long idRestaurante);

    Restaurante buscarRestaurantePorId(Long idRestaurante);

    List<Restaurante> buscarPorLocalidad(Long idLocacion);

    List<Plato> verPlatosMasVendidosDelRestaurante(Long idRestaurante);
}
