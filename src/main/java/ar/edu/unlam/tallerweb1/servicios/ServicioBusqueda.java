package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;

import java.util.List;

public interface ServicioBusqueda {

    List<Plato> buscar(String nombrePlato);

    List<Plato> listaPlatosMasVendidos();

    List<Plato> buscar(Double precio);

    List<Plato> buscar(String nombrePlato, Double precio);

    List<Plato> buscar(Double precio, String localidadRestaurante);

    List<Plato> buscar(String nombrePlato, String localidadRestaurante);

    List<Plato> buscar(String nombrePlato, Double precio, String localidadRestaurante);


}
