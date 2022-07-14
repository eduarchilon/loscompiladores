package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioLocalidadImpl implements  RepositorioLocalidad{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLocalidadImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Localidad> verLocalidades() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Localidad>) sessionFactory.getCurrentSession()
                .createCriteria(Localidad.class)
                .list();
    }
}
