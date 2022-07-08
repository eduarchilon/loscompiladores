package ar.edu.unlam.tallerweb1.repositorios;
import ar.edu.unlam.tallerweb1.modelo.Mesa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RespositorioMesaImpl implements RespositorioMesa{

    private SessionFactory sessionFactory;

    @Autowired
    public RespositorioMesaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Mesa> obetenerMesasDelRestaurante(Long idRestaurante) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Mesa>) sessionFactory.getCurrentSession()
                .createCriteria(Mesa.class, "restaurante")
                .createAlias("restaurante", "rest")
                .add(Restrictions.eq("rest.id", idRestaurante))
                .list();
    }

    @Override
    public Integer obtenerCantidadDeMesasDelResturante(Long idRestaurante) {
        return null;
    }
}
