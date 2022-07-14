package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTipoGusto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service @Transactional
public class ServicioTipoGustoImpl implements ServicioTipoGusto{

    private RepositorioTipoGusto repositorioTipoGusto;

    @Autowired
    public ServicioTipoGustoImpl(RepositorioTipoGusto repositorioTipoGusto) {
        this.repositorioTipoGusto = repositorioTipoGusto;
    }

    @Override
    public List<TipoGusto> verTodosLosGustos() {
        return repositorioTipoGusto.getTodosLosGustos();
    }

    @Override
    public List<Plato> verPlatosPorGusto(Long idTipoGusto) {
        return repositorioTipoGusto.getPlatosPorGusto(idTipoGusto);
    }
}
