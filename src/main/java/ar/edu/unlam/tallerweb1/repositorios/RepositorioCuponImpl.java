package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCuponImpl implements RepositorioCupon{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCuponImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cupon buscarCuponPorNombre(String cuponNombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (Cupon) session.createCriteria(Cupon.class)
                .add(Restrictions.eq("nombre", cuponNombre))
                .uniqueResult();
    }
}
