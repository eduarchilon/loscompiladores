package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface RepositorioPlato {
    List<Plato> buscar(String nombrePlato);

    List<Plato> platosMasVendidos();

    List<Plato> buscar(Double precio);

    List<Plato> buscar(String nombrePlato, Double precio);

    List<Plato> buscar(Double precio, String localidadRestaurante);

    List<Plato> buscar(String nombrePlato, Double precio, String localidadRestaurante);

    List<Plato> buscar(String nombrePlato, String localidadRestaurante);

    List<Plato> buscarTodos();

}