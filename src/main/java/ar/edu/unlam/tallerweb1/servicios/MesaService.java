package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;

import java.util.List;

public interface MesaService {

    List<Mesa> getMesasDelRestaurante(Long idResto);

    Mesa getMesaPorId(Long mesaId);
}
