package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioCarritoImpl implements RepositorioCarrito{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCarritoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Plato> verTodosLoaPlatos(Long idCarrito) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Plato>) sessionFactory.getCurrentSession()
                .createCriteria(Carrito.class, "platos")
                .createAlias("platos", "plat")
                .add(Restrictions.eq("id", idCarrito))
                .list();
    }

    @Override
    public Plato detalleDelPlato(Long idPlato) {
        return null;
    }

    @Override
    public List<Restaurante> verTodosLosRestaurantesDelCarrito(Long idCarrito) {
        return null;
    }

    @Override
    public Restaurante detalleDelResturante(Long idRestaurante) {
        return null;
    }

    @Override
    public Carrito verCarrito(Long idCarrito) {
        final Session session = sessionFactory.getCurrentSession();
        return (Carrito) sessionFactory.getCurrentSession()
                .createCriteria(Carrito.class, "carrito")
                .add(Restrictions.eq("id", idCarrito))
                .uniqueResult();
    }

    /*Nuevo*/

    @Override
    public List<Carrito> verTodosLosPlatos() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Carrito>) sessionFactory.getCurrentSession()
                .createCriteria(Carrito.class)
                .list();
    }

    @Override
    public Boolean borrarPlato(Long idPlatoCarrito) {
        final Session session = sessionFactory.getCurrentSession();
        Carrito carrito = (Carrito) sessionFactory.getCurrentSession()
                .createCriteria(Carrito.class)
                .add(Restrictions.eq("id", idPlatoCarrito))
                .uniqueResult();
                session.delete(carrito);
                session.flush();
        return true;
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        String hql = "DELETE FROM Carrito car "  +
//                "WHERE car.id = :id";
//        Query query = session.createQuery(hql);
//        query.setParameter("id", idPlatoCarrito);
//        int result = query.executeUpdate();
//        System.out.println("Rows affected: " + result);
//        return true;
    }
}
