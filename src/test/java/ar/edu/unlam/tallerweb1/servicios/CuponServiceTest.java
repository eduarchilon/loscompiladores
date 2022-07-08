package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cupon;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCupon;
import ar.edu.unlam.tallerweb1.repositorios.RespositorioMesa;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuponServiceTest {

    private RepositorioCupon repositorioCupon;
    private CuponService cuponService;
    private List<Plato> platos;

    @Before
    public void init() {
        repositorioCupon = mock(RepositorioCupon.class);
        cuponService = new CuponServiceImpl(repositorioCupon);
    }

    @Test
    public void queObtengaUnDescuentoConUncupon(){
        Plato plato1 = new Plato();
        plato1.setPrecio(1000.0);
        Plato plato2 = new Plato();
        plato2.setPrecio(1000.0);
        Plato plato3 = new Plato();
        plato3.setPrecio(1000.0);
        Plato plato4 = new Plato();
        plato4.setPrecio(1000.0);

        platos = new LinkedList<>();
        platos.add(plato1);
        platos.add(plato2);
        platos.add(plato3);
        platos.add(plato4);

        Cupon cupon = new Cupon(1L, "TUENTI", 10);

        when(repositorioCupon.buscarCuponPorNombre("TUENTI")).thenReturn(cupon);

        Cupon cuponBuscado = (Cupon)repositorioCupon.buscarCuponPorNombre("TUENTI");

        Double subTotaltotal = 0.0;
        for (int i = 0; i < platos.size() ; i++) {
            subTotaltotal += platos.get(i).getPrecio();
        }

       when(cuponService.obetenerCupon(cuponBuscado.getNombre())).thenReturn(cuponBuscado);

        Double canje = cuponService.canjearCuponEnPorcentaje(cuponBuscado);

        Double descuentoEnNumero = subTotaltotal * canje;

        Double total = subTotaltotal - descuentoEnNumero;

        System.out.println("SUBTOTAL: " + subTotaltotal);
        System.out.println("DESCUENTO APLICADO EN %: " + canje*100);
        System.out.println("DESCUENTO APLICADO: " + descuentoEnNumero);
        System.out.println("TOTAL: " + total);

    }


}
