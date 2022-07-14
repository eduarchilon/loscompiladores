package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface PlatoService {

    public List<Plato> verPlatos();
    public Integer verCantidadDePlatos();

    Plato buscarPlato(Long idPlato);

    Boolean agregarAdcionalesAlPlato(Long id, Long id1);

    List<Adicional> verAdicionalesDeLPlato(Long idPlato);
}
