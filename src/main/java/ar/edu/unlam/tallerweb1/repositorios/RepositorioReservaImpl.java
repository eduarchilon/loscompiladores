package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public List<Mesa> buscaMesasDisponibles(Restaurante resto, Calendar fechaReserva) {
        final Session session = sessionFactory.getCurrentSession();
        List<Mesa> mesas = session.createQuery(
                "from Mesa where restaurante.id = "+resto.getId()+" and id NOT IN (select mesa.id from Reserva )"
        ).list();
        //+" and Mesa.id NOT IN (select Mesa.id from Reserva )
        //select * from Mesa where id_mesa NOT IN (select id_mesa from Reserva R) and id_restaurante=1;
        return mesas;
    }

    @Override
    public List<Mesa> buscaMesasDisponiblesSegunHorario(Restaurante resto, Calendar fechaReserva) {
        Session session = sessionFactory.getCurrentSession();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startDate = fechaReserva;

        startDate.set(startDate.MINUTE,00);
        startDate.set(startDate.SECOND,00);

        Calendar endDate = fechaReserva;
        endDate.set(endDate.MINUTE,59);
        endDate.set(endDate.SECOND,59);
        Date algo = null;

        List mesas = session.createQuery(
                        "from Mesa where restaurante.id = "+resto.getId()+" and id NOT IN (select mesa.id from Reserva where fecha BETWEEN :stDate AND :edDate )"
                ).setParameter("stDate", startDate)
                .setParameter("edDate", endDate)
                .list();
        return mesas;
    }

    @Override
    public Reserva buscarReservaPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Reserva reserva = (Reserva) session.createCriteria(Reserva.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        session.flush();
        return reserva;
    }

    @Override
    public List<Reserva> buscarTodasLasReservasRestaurante(Long id) {
        final Session session = sessionFactory.getCurrentSession();
//        List reserva = session.createQuery(
//                        "from Reserva R where R.mesa IN  (select mesa from Mesa M where M.restaurante.id = :idResto) "
//                ).setParameter("idResto", id)
//                .list();

        return (List<Reserva>) session.createCriteria(Reserva.class,"mesa")
                .createAlias("mesa","M")
                .createAlias("M.restaurante","resto")
                .add(Restrictions.eq("resto.id",id))
                .list();
    }

    @Override
    public Long crearReserva(Reserva reserva1) {
        final Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        long id = (long) session.save(reserva1);
        session.close();
        return id;
    }

    @Override
    public Boolean eliminarReserva(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        if(id!=null){
            Reserva reserva = (Reserva) sessionFactory.getCurrentSession()
                    .createCriteria(Reserva.class)
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();
            session.delete(reserva);
            session.flush();
            return true;
        }
        return false;


    }

}


