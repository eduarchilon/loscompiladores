package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Adicional;
import ar.edu.unlam.tallerweb1.modelo.TipoGusto;

import java.util.List;

public interface ServicioAdicional {

    List<Adicional> getAdicionales();

    List<Adicional> getAdicionalesPorGusto(TipoGusto vegetariano);

    Double calcularTodosLosAdicionalesPorGusto(TipoGusto arabe);
}
