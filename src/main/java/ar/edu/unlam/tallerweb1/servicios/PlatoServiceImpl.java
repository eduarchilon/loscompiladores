package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlatoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlatoServiceImpl implements PlatoService{



    Plato plato1 = new Plato(1L, TipoPlato.VEGANO, "Solo verduras");

    Plato plato2 = new Plato(2L, TipoPlato.VEGETARIANO, "verduras y huevo");

    Plato plato3 = new Plato(3L, TipoPlato.TIPICA, "Milanesa y pure de papa");

    private List<Plato> platos = new ArrayList<>();

    private RepositorioPlato repositorioPlato ;

    @Autowired
    public PlatoServiceImpl(RepositorioPlato repositorioPlato) {
        this.repositorioPlato = repositorioPlato;
    }

    @Override
    public List<Plato> verPlatos() {

        List<Plato> lista = repositorioPlato.buscarTodos();
        return lista;

    }

    @Override
    public Integer verCantidadDePlatos() {
        return platos.size();
    }


}
