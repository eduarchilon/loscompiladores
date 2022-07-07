package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CuponServiceImpl implements CuponService{

    private RepositorioCupon repositorioCupon;

    @Autowired
    public CuponServiceImpl(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    @Override
    public Cupon obetenerCupon(String cuponNombre) {
        return (Cupon)repositorioCupon.buscarCuponPorNombre(cuponNombre);
    }

    @Override
    public Double canjearCuponEnPorcentaje(Cupon cupon) {
        Double porcentaje = 0.0;
        porcentaje = (cupon.getDescuento()/100.0);
        return porcentaje;
    }
}
