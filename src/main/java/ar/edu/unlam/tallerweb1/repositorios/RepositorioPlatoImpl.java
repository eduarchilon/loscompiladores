package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RepositorioPlatoImpl implements RepositorioPlato{

    private SessionFactory sessionFactory;
    private EntityManager em;

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

    @Override
    public List<Plato> buscarPlatoPorLocalidadRestaurante(String localidadRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria plato = session.createCriteria(Plato.class, "plato");
        plato.createAlias("plato.restaurante","restaurante");
        return plato.add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
                .list();
    }

    @Override
    public Plato buscarPlato(Long idPlato) {
        final Session session = sessionFactory.getCurrentSession();
        return (Plato) sessionFactory.getCurrentSession()
                .createCriteria(Plato.class)
                .add(Restrictions.eq("id", idPlato))
                .uniqueResult();
    }

    @Override
    public Boolean agregarAdicionalAlPlato(Long idAdicional, Long idPlato) {
        final Session session = sessionFactory.getCurrentSession();
        if(idPlato!=null){
            Adicional adicional = (Adicional) sessionFactory.getCurrentSession()
                    .createCriteria(Adicional.class)
                    .add(Restrictions.eq("id", idAdicional))
                    .uniqueResult();
            Plato plato = (Plato) sessionFactory.getCurrentSession()
                    .createCriteria(Plato.class)
                    .add(Restrictions.eq("id", idPlato))
                    .uniqueResult();
            List<Adicional> otro = new LinkedList<>();
            otro.add(adicional);
            plato.setAdicionales(otro);
            session.saveOrUpdate(plato);
            session.flush();
            return true;
        }
        return false;
    }

    @Override
    public List<Adicional> verAdicionalesDelPlato(Long idPlato) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Adicional>)session.createCriteria(Plato.class)
                .add(Restrictions.eq("id", idPlato))
                .list();
    }

}
