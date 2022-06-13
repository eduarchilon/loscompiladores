package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Pedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPedidoImpl implements RepositorioPedido{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPedidoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Pedido buscarPedido(Long idPedido) {
        final Session session = sessionFactory.getCurrentSession();
        return (Pedido) session.createCriteria(Pedido.class)
                .add(Restrictions.eq("id", idPedido))
                .uniqueResult();

    }

    @Override
    public List<Pedido> buscarPedidosCliente(Cliente id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Pedido>) session.createCriteria(Pedido.class)
//                .createAlias("cliente", "cli", Criteria.FULL_JOIN)
                .add(Restrictions.eq("cliente",  id))
                .list();
    }

    @Override
    public List<Pedido> verPedidos() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Pedido>) session.createCriteria(Pedido.class)
                .list();
    }

    @Override
    public List<Plato> verPlatosDelPedido(Long pedido) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Plato>) session.createCriteria(Plato.class)
                .add(Restrictions.eq("id_Pedido", pedido))
                .list();
    }


}
