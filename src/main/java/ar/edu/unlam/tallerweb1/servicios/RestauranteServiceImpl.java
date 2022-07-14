package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Restaurante;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class RestauranteServiceImpl implements RestauranteService{

    private RepositorioRestaurante repositorioRestaurante;

    @Autowired
    public RestauranteServiceImpl(RepositorioRestaurante repositorioRestaurante) {
        this.repositorioRestaurante = repositorioRestaurante;
    }


    @Override
    public List<Restaurante> getRestaurantesMasCalificados() {
        List<Restaurante> lista = repositorioRestaurante.verTodosLosRestaurantes();
        List<Restaurante> nuevaLista = new LinkedList<>();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getCalificacion()>=4){
                nuevaLista.add(lista.get(i));
            }
        }
        return nuevaLista;
    }

    @Override
    public List<Restaurante> verTodosLosRestaurantes() {
        List<Restaurante> lista = repositorioRestaurante.verTodosLosRestaurantes();
        return lista;
    }

    @Override
    public List<Plato> verPlatosDelRestaurante(Long idRestaurante) {
        List<Plato> platos = (List<Plato>) repositorioRestaurante.verPlatosDelRestaurante(idRestaurante);
        return platos;
    }

    @Override
    public Restaurante buscarRestaurantePorId(Long idRestaurante) {
        Restaurante buscado = repositorioRestaurante.verRestaurante(idRestaurante);
        return buscado;
    }

    @Override
    public List<Restaurante> buscarPorLocalidad(Long idLocacion) {
        return (List<Restaurante>) repositorioRestaurante.buscarRestuarntesPorLocalidad(idLocacion);
    }

    @Override
    public List<Plato> verPlatosMasVendidosDelRestaurante(Long idRestaurante) {
        List<Plato> platos = repositorioRestaurante.verPlatosDelRestaurante(idRestaurante);
        List<Plato> platosMasVendidos = new LinkedList<>();
        for (int i = 0; i < platos.size(); i++) {
            if(platos.get(i).getCantVentas()>=5){
                platosMasVendidos.add(platos.get(i));
            }
        }
        return platosMasVendidos;
    }
}
