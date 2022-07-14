package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Carrito;
import ar.edu.unlam.tallerweb1.modelo.CarritoAdicional;
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

    @Override
    public Boolean borrarPlatoDelCarrito(Long idPlatoCarrito) {
        return repositorioCarrito.borrarPlato(idPlatoCarrito);
    }

    @Override
    public void agregarPlatoAlCarrito(Long plato) {
        repositorioCarrito.cargarAlCarrito(plato);
    }

    @Override
    public Double getSubtotal(List<Carrito> platos) {
        Double total = 0.0;
        for (int i = 0; i <platos.size() ; i++) {
            total += platos.get(i).getPlato().getPrecio();
        }
        return total;
    }

    @Override
    public Double getTotal(Double subtotal, Double descuento) {
        Double total = subtotal - descuento;
        return total;
    }




//    Carrito Adicionales


    @Override
    public List<CarritoAdicional> verListDeAdicionalesDelCarrito() {
        List<CarritoAdicional> adicionales = (List<CarritoAdicional>) repositorioCarrito.verTodosLosAdicionales();
        return adicionales;
    }

    @Override
    public Boolean borrarAdicionalDelCarrito(Long idAdicionalCarrito) {
        return repositorioCarrito.borrarAdicional(idAdicionalCarrito);
    }

    @Override
    public void agregarAdicionalAlCarrito(Long adicional) {
        repositorioCarrito.cargarAlCarritoAdicional(adicional);
    }

    @Override
    public Double getSubtotalAdicionales(List<CarritoAdicional> adicionales) {
        Double total = 0.0;
        for (int i = 0; i <adicionales.size() ; i++) {
            total += adicionales.get(i).getAdicional().getPrecio();
        }
        return total;
    }


}
