package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;

import java.util.List;

public interface RepositorioTipoGusto {

    List<TipoGusto> getTodosLosGustos();
    List<Plato> getPlatosPorGusto(Long idTipoGusto);
}
