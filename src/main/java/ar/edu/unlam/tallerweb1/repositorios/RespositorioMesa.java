package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

import java.util.List;

public interface RespositorioMesa {

    List<Mesa> obetenerMesasDelRestaurante(Long idRestaurante);
    Integer obtenerCantidadDeMesasDelResturante(Long idRestaurante);

    Mesa obtenerMesaPorId(Long mesaId);

}

