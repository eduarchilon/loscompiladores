package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RepositorioReservaImpl implements RepositorioReserva {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioReservaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Plato> verPlatosDelCliente(Cliente cliente) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Reserva.class)
                .add(Restrictions.isNotNull("id_plato"))
                .add(Restrictions.eq("id_cliente", cliente.getId()))
                .setMaxResults(2)
                .list();
    }

    @Override
    public List<Reserva> buscarTodasLasReservas() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Reserva.class)
                .list();
    }

    @Override
    public List<Reserva> buscarUnaReservas() {
        return null;
        //plato.add(Restrictions.le("precio", precio))
        //                .add(Restrictions.like("nombre", "%"+nombrePlato+"%"))
        //                .add(Restrictions.eq("restaurante.localidad", localidadRestaurante))
        //                .list();
    }

    @Override
    public List<Reserva> buscarReservasCliente(Cliente cliente) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Reserva.class)
                .add(Restrictions.eq("id_cliente", cliente))
                .setMaxResults(1)
                .list();
    }

}

