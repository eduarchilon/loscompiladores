package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import java.util.List;

public interface PlatoService {

    public List<Plato> verPlatos();
    Plato buscarPlato(Long idPlato);
}
