package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoGusto;

import java.util.List;

public interface ServicioTipoGusto {


    List<TipoGusto> verTodosLosGustos();

    List<Plato> verPlatosPorGusto(Long idTipoGusto);
}
