package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;

import java.util.List;

public interface RepositorioRestaurante {

    List<Restaurante> buscarPorNombre(String nombre);

    List<Restaurante> buscarPorCalificacion(Integer calificacion);

    List<Restaurante> buscarPorLocalidad(String localidadRestaurante);
}
