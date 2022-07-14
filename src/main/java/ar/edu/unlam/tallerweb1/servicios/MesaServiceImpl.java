package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Mesa;
import ar.edu.unlam.tallerweb1.repositorios.RespositorioMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class MesaServiceImpl implements MesaService {

    private RespositorioMesa repositorioMesa;

    @Autowired
    public MesaServiceImpl(RespositorioMesa respositorioMesa){
        this.repositorioMesa=respositorioMesa;
    }

    @Override
    public List<Mesa> getMesasDelRestaurante(Long idResto) {
        List<Mesa> mesas = repositorioMesa.obetenerMesasDelRestaurante(idResto);
        return mesas;
    }

    @Override
    public Mesa getMesaPorId(Long mesaId) {
        Mesa mesa = repositorioMesa.obtenerMesaPorId(mesaId);
        return mesa;
    }

}

