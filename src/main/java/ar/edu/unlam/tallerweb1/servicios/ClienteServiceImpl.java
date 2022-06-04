package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService{

    private RepositorioCliente repositorioCliente;

    @Autowired
    public ClienteServiceImpl(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    @Override
    public Cliente verCliente(Cliente cliente) {
        Cliente buscado = repositorioCliente.buscarPorId(cliente.getId());
        return buscado;
    }

    @Override
    public Usuario obtenerClientePorNombre(Cliente cliente) {
        Usuario buscado = repositorioCliente.buscarPorNombre(cliente.getNombre());
        return  buscado;
    }

}
