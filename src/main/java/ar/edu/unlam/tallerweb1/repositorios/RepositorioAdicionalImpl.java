package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioAdicionalImpl implements RepositorioAdicional{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAdicionalImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Adicional> getTodosLosAdicionales() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Adicional>) sessionFactory.getCurrentSession()
                .createCriteria(Adicional.class)
                .list();
    }
}
