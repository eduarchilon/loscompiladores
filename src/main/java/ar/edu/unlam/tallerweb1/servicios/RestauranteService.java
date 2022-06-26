package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Restaurante;

import java.util.List;

public interface RestauranteService {

    List<Restaurante> getRestaurantesMasCalificados();

    List<Restaurante> verTodosLosRestaurantes();
}
