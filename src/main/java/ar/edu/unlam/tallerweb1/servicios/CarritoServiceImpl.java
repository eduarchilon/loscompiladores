package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CarritoServiceImpl implements CarritoService{

    private RepositorioCarrito repositorioCarrito;

    @Autowired
    public CarritoServiceImpl(RepositorioCarrito repositorioCarrito) {
        this.repositorioCarrito = repositorioCarrito;
    }

    @Override
    public Carrito verPlatosDelCarrito(Long idCarrito) {
        return (Carrito)repositorioCarrito.verCarrito(idCarrito);
    }

    @Override
    public List<Carrito> verListDePlatosDelCarrito() {
        List<Carrito> platos = (List<Carrito>) repositorioCarrito.verTodosLosPlatos();
        return platos;
    }
}
