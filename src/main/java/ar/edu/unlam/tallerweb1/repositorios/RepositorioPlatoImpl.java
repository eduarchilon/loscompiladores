package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPlatoImpl implements RepositorioPlato{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPlatoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Plato> buscar(String nombrePlato) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        return plato.add(Restrictions.like("nombre", "%"+nombrePlato+"%"))
                .list();
    }

    @Override
    public List<Plato> buscar(Double precio) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        return plato.add(Restrictions.le("precio", precio))
                .list();
    }

    @Override
    public List<Plato> buscar(String nombrePlato, Double precio) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        return plato.add(Restrictions.eq("precio", precio))
                .add(Restrictions.like("nombre", "%"+nombrePlato+"%"))
                .list();
    }

    @Override
    public List<Plato> platosMasVendidos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Plato.class)
                .addOrder( Order.desc("cantVentas") )
//                .add(Restrictions.)
                .list();
    }

    public List<Plato> buscar(Double precio, String localidadRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        plato.createAlias("plato.restaurante","restaurante");
        return plato.add(Restrictions.le("precio", precio))
                .add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
                .list();
    }

    @Override
    public List<Plato> buscar(String nombrePlato, Double precio, String localidadRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        plato.createAlias("plato.restaurante","restaurante");
        return plato.add(Restrictions.le("precio", precio))
                .add(Restrictions.like("nombre", "%"+nombrePlato+"%"))
                .add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
                .list();
    }

    @Override
    public List<Plato> buscar(String nombrePlato, String localidadRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        plato.createAlias("plato.restaurante","restaurante");
        return plato.add(Restrictions.like("nombre", "%"+nombrePlato+"%"))
                .add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
                .list();
    }

    @Override
    public List<Plato> buscarTodos() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Plato.class)
                .list();
    }

    @Override
    public Plato buscarPlatoAAgregarEnDetalle(String nombrePlato, String descripcionPlato, String nombreRestaurante, String localidadRestaurante, Double precio) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        plato.createAlias("plato.restaurante","restaurante");
        return (Plato) plato.add(Restrictions.eq("nombre", nombrePlato))
                .add(Restrictions.eq("descripcion", descripcionPlato))
                .add(Restrictions.eq("precio", precio))
                .add(Restrictions.eq("restaurante.nombre", nombreRestaurante))
                .add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
                .uniqueResult();
    }

}
