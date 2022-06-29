package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioDetallePedidoImpl implements RepositorioDetallePedido {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioDetallePedidoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void agregarPlatoAlDetallePedido(Plato plato, Cliente cliente) {
        Session session = sessionFactory.openSession();
        DetallePedido detallePedido = new DetallePedido(plato,cliente);
        session.save(detallePedido);
        session.close();
    }

    @Override
    public List<DetallePedido> buscarPorIdCliente(Cliente cliente) {
        Long idCliente = cliente.getId();
        final Session session = sessionFactory.getCurrentSession();
        Criteria detallePedido = session.createCriteria(DetallePedido.class, "detallePedido");
        detallePedido.createAlias("detallePedido.cliente","cliente");
        return detallePedido.add(Restrictions.eq("cliente.id", idCliente))
                .list();
    }

    @Override
    public void eliminarPlatoDelDetallePedido(Long idPlato, Cliente cliente) {
        Session session = sessionFactory.openSession();
        DetallePedido platoEncontrado = this.buscarDetallePedido(idPlato, cliente);
        System.out.println(platoEncontrado.getId_detallePlato());
        session.delete(platoEncontrado);
        session.close();
    }

    @Override
    public DetallePedido buscarDetallePedido(Long idPlato, Cliente cliente) {
        Long idCliente = cliente.getId();
        final Session session = sessionFactory.getCurrentSession();
//        Criteria detallePedido = session.createCriteria(DetallePedido.class, "detallePedido");
//        detallePedido.createAlias("detallePedido.cliente","cliente");
//        detallePedido.createAlias("detallePedido.plato","plato");
//        return (DetallePedido) detallePedido.add(Restrictions.eq("cliente.id", idCliente))
//                .add(Restrictions.eq("plato.id", idPlato))
//                .uniqueResult();
        Criteria detallePedido = session.createCriteria(DetallePedido.class,"detallePedido");
            detallePedido.createAlias("detallePedido.cliente","cliente");
        return (DetallePedido) detallePedido.add(Restrictions.eq("cliente.id", idCliente))
            .add(Restrictions.eq("id", idPlato))
            .uniqueResult();
    }


}
