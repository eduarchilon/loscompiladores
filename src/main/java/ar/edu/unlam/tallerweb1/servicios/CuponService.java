package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cupon;

public interface CuponService {

    Cupon obetenerCupon(String cuponNombre);

    Double canjearCuponEnPorcentaje(Cupon cupon);
}
