package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAdicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ServicioAdicionalImpl implements ServicioAdicional{

    private RepositorioAdicional repositorioAdicional;

    @Autowired
    public ServicioAdicionalImpl(RepositorioAdicional repositorioAdicional) {
        this.repositorioAdicional = repositorioAdicional;
    }

    @Override
    public List<Adicional> getAdicionales() {
        return repositorioAdicional.getTodosLosAdicionales();
    }

    @Override
    public List<Adicional> getAdicionalesPorGusto(TipoGusto tipo) {
        List<Adicional> lista = repositorioAdicional.getTodosLosAdicionales();

        List<Adicional> listaFiltrada = new LinkedList();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getTipo().getId().equals(tipo.getId())){
                listaFiltrada.add(lista.get(i));
            }
        }
        return listaFiltrada;
    }

    @Override
    public Double calcularTodosLosAdicionalesPorGusto(TipoGusto arabe) {
        Double precioTotal = 0.00;
        List<Adicional> lista = this.getAdicionalesPorGusto(arabe);
        for (int i = 0; i < lista.size(); i++) {
                precioTotal+= lista.get(i).getPrecio();
        }
        return precioTotal;
    }
}
