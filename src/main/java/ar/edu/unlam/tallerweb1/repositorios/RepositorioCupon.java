package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface RepositorioCupon {

    Cupon buscarCuponPorNombre(String cuponNombre);
}
