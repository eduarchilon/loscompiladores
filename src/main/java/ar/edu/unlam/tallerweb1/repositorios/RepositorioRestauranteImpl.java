package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioRestauranteImpl implements RepositorioRestaurante {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRestauranteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Restaurante> buscarPorNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Restaurante.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
    }

    @Override
    public List<Restaurante> buscarPorCalificacion(Integer calificacion) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Restaurante.class)
                .add(Restrictions.eq("calificacion", calificacion))
                .list();
    }

    @Override
    public List<Restaurante> buscarPorLocalidad(String localidadRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Restaurante.class)
                .add(Restrictions.eq("localidad", localidadRestaurante))
                .list();
    }

    @Override
    public List<Restaurante> verTodosLosRestaurantes() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Restaurante>) session.createCriteria(Restaurante.class)
                .list();
    }

    @Override
    public Restaurante verRestaurante(Long isRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
                return (Restaurante) sessionFactory.getCurrentSession()
                .createCriteria(Restaurante.class)
                .add(Restrictions.eq("id", isRestaurante))
                        .uniqueResult();
    }

    @Override
    public List<Restaurante> buscarRestuarntesPorLocalidad(Long idLocalidad) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Restaurante>) sessionFactory.getCurrentSession()
                .createCriteria(Restaurante.class, "locacion")
                .createAlias("locacion", "loc")
                .add(Restrictions.eq("loc.id", idLocalidad))
                .list();
    }

    @Override
    public List<Plato> verPlatosDelRestaurante(Long idRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Plato>) sessionFactory.getCurrentSession()
                /*el alias que esta a lado del .class es el atributo del la clase*/
                .createCriteria(Plato.class, "restaurante")
                .createAlias("restaurante", "resto")
                .add(Restrictions.eq("resto.id", idRestaurante))
                .list();
    }


}
