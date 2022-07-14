package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Cliente verClientePorId(Long clienteId) {
        Cliente buscado = repositorioCliente.buscarPorId(clienteId);
        return buscado;
    }

    @Override
    public Cliente obtenerClientePorNombre(String cliente) {
        Cliente clienteBuscado = repositorioCliente.buscarPorNombre(cliente);
        return clienteBuscado;
    }

    @Override
    public List<Cliente> verClientes(){
        List<Cliente> clientes = repositorioCliente.buscarCliente();
        return clientes;
    }

}
