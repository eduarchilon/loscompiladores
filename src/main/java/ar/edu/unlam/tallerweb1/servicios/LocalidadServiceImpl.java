package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocalidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocalidadServiceImpl implements LocalidadService{

    private RepositorioLocalidad repositorioLocalidad;

    @Autowired
    public LocalidadServiceImpl(RepositorioLocalidad repositorioLocalidad) {
        this.repositorioLocalidad = repositorioLocalidad;
    }

    @Override
    public List<Localidad> verLocalidades() {
        return (List<Localidad>) repositorioLocalidad.verLocalidades();
    }
}
