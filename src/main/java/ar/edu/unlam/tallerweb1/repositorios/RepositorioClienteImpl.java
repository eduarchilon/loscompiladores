
package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioClienteImpl implements RepositorioCliente {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioClienteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Cliente buscarPorId(Long idCliente) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria cliente = session.createCriteria(Cliente.class, "cliente");
        return (Cliente) cliente.add(Restrictions.eq("id", idCliente))
                .uniqueResult();
    }


    @Override
    public Usuario buscarPorUsuario(Usuario usuarioCliente) {
        final Session session = sessionFactory.getCurrentSession();
        return (Usuario) session.createCriteria(Cliente.class)
                .add(Restrictions.eq("usuario", usuarioCliente));
    }

    @Override
    public Cliente buscarPorNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (Cliente) session.createCriteria(Cliente.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    @Override
    public List<Cliente> buscarCliente() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Cliente>) session.createCriteria(Cliente.class).list();
    }
}

