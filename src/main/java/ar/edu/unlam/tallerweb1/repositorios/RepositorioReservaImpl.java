package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
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
                .add(Restrictions.eq("cliente.id", cliente.getId()))
                .list();
    }

    @Override
    public List<Mesa> buscaMesasDisponibles(Restaurante resto, Date fechaReserva) {
        final Session session = sessionFactory.getCurrentSession();
        List<Mesa> mesas = session.createQuery(
                "from Mesa where restaurante.id = "+resto.getId()+" and id NOT IN (select mesa.id from Reserva )"
        ).list();
        //+" and Mesa.id NOT IN (select Mesa.id from Reserva )
        //select * from Mesa where id_mesa NOT IN (select id_mesa from Reserva R) and id_restaurante=1;
        return mesas;
    }

    @Override
    public List<Mesa> buscaMesasDisponiblesSegunHorario(Restaurante resto, Date fechaReserva) {
        final Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(
                "from Mesa where restaurante.id = "+resto.getId()+" and id NOT IN (select mesa.id from Reserva where fecha = :fechaReserva)"
        );
        q.setTimestamp("fechaReserva", fechaReserva);
        List<Mesa> mesas = q.list();
        //select * from Reserva where fecha = TIMESTAMP('2023-06-13 00:11:12');
//        List mesas = session.createQuery(
//                "from Mesa where restaurante.id = "+resto.getId()+" and id NOT IN (select mesa.id from Reserva where fecha = DATE('"+String.format(String.valueOf(fechaReserva))+"'))"
//        ).list();
        //+" and Mesa.id NOT IN (select Mesa.id from Reserva )
        //select * from Mesa where id_mesa NOT IN (select id_mesa from Reserva R) and id_restaurante=1;
        return mesas;
    }

}

