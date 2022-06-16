package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service @Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda{

    private RepositorioRestaurante repositorioRestaurante;
    private RepositorioPlato repositorioPlato;

    @Autowired
    public ServicioBusquedaImpl(RepositorioPlato repositorioPlato, RepositorioRestaurante repositorioRestaurante){
        this.repositorioPlato = repositorioPlato;
        this.repositorioRestaurante = repositorioRestaurante;
    }

    @Override
    public List<Plato> buscar(String nombrePlato){
        if(nombrePlato == ""){
            return new LinkedList<>();
        }
        List<Plato> platos= repositorioPlato.buscar(nombrePlato);
        return platos;
    }
    public List<Plato> buscar(Double precio){
        if(precio == 0.0){
            return new LinkedList<>();
        }
        List<Plato> platos= repositorioPlato.buscar(precio);
        return platos;
    }
    @Override
    public List<Plato> buscar(String nombrePlato, Double precio) {
        List<Plato> platos= repositorioPlato.buscar(nombrePlato, precio);
        return platos;
    }

    @Override
    public List<Plato> buscar(Double precio, String localidadRestaurante) {
        List<Plato> platos= repositorioPlato.buscar(precio, localidadRestaurante);
        return platos;
    }
    @Override
    public List<Plato> buscar(String nombrePlato, Double precio, String localidadRestaurante) {
        List<Plato> platos= repositorioPlato.buscar(nombrePlato, precio, localidadRestaurante);
        return platos;
    }

    @Override
    public List<Plato> buscarPlatoPorLocalidadRestaurante(String localidadRestaurante) {
        List<Plato> platos= repositorioPlato.buscarPlatoPorLocalidadRestaurante(localidadRestaurante);
        return platos;
    }

    @Override
    public List<Plato> buscar(String nombrePlato, String localidadRestaurante) {
        List<Plato> platos= repositorioPlato.buscar(nombrePlato, localidadRestaurante);
        return platos;
    }

    @Override
    public List<Plato> listaPlatosMasVendidos() {
        List<Plato> platos = repositorioPlato.platosMasVendidos();
        return platos;
    }




}
