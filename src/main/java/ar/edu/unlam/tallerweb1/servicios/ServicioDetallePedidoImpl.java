package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DetallePedido;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDetallePedido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service @Transactional
public class ServicioDetallePedidoImpl implements ServicioDetallePedido{

    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioPlato repositorioPlato;
    private RepositorioCliente repositorioCliente;

    @Autowired
    public ServicioDetallePedidoImpl(RepositorioDetallePedido repositorioDetallePedido, RepositorioPlato repositorioPlato, RepositorioCliente repositorioCliente){
        this.repositorioDetallePedido = repositorioDetallePedido;
        this.repositorioPlato = repositorioPlato;
        this.repositorioCliente = repositorioCliente;
    }


    @Override
    public void agregarPlatoAlDetallePedido(HttpServletRequest request) {
        Plato platoEncontrado = this.buscarPlato(request);
        Long idCliente = Long.valueOf(request.getParameter("idCliente"));
        Cliente clienteEncontrado = repositorioCliente.buscarPorId(idCliente);

        repositorioDetallePedido.agregarPlatoAlDetallePedido(platoEncontrado, clienteEncontrado);

    }

    @Override
    public Plato buscarPlato(HttpServletRequest request) {
        Plato platoEncontrado;
        String nombrePlato = request.getParameter("nombrePlatoElegido");
        String descripcionPlato = request.getParameter("descripcionPlatoElegido");
        String nombreRestaurante = request.getParameter("nombreRestauranteElegido");
        String nombreLocalidad = request.getParameter("localidadRestauranteElegido");
        Double precioPlato = Double.valueOf(request.getParameter("precioPlatoELegido"));


        platoEncontrado = repositorioPlato.buscarPlatoAAgregarEnDetalle(nombrePlato, descripcionPlato, nombreRestaurante, nombreLocalidad, precioPlato);

        return platoEncontrado;
    }

    @Override
    public void eliminarPlatoDelDetallePedido(HttpServletRequest request) {
//        Plato platoEncontrado = this.buscarPlato(request);
        Long idCliente = Long.valueOf(request.getParameter("idCliente"));
        Long idDetallePlato = Long.valueOf(request.getParameter("idPlatoElegido"));
        Cliente clienteEncontrado = repositorioCliente.buscarPorId(idCliente);

        repositorioDetallePedido.eliminarPlatoDelDetallePedido(idDetallePlato, clienteEncontrado);
    }

    @Override
    public List<DetallePedido> buscarPorIdCliente(HttpServletRequest request) {
        Long idCliente = Long.valueOf(request.getParameter("idCliente"));
        Cliente clienteEncontrado = repositorioCliente.buscarPorId(idCliente);

        List<DetallePedido> listaDetalles = repositorioDetallePedido.buscarPorIdCliente(clienteEncontrado);

        return listaDetalles;
    }


}
