package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoGustoImpl implements RepositorioTipoGusto{


    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTipoGustoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TipoGusto> getTodosLosGustos() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<TipoGusto>) sessionFactory.getCurrentSession()
                .createCriteria(TipoGusto.class)
                .list();
    }

    @Override
    public List<Plato> getPlatosPorGusto(Long idTipoGusto) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Plato>) sessionFactory.getCurrentSession()
                .createCriteria(Plato.class, "tipo")
                .createAlias("tipo", "tip")
                .add(Restrictions.eq("tip.id", idTipoGusto))
                .list();
    }
}
