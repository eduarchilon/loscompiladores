package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.forms.FormBuscarPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorBusqueda {

    private ServicioBusqueda servicioBusqueda;

    @Autowired
    public ControladorBusqueda(ServicioBusqueda servicioBusqueda){
        this.servicioBusqueda = servicioBusqueda;
    }

    @RequestMapping(path = "ir-a-busqueda-plato")
    public ModelAndView irABuscarPlato(){
        ModelMap model = new ModelMap();
        model.put("formBuscarPlato", new FormBuscarPlato());
        return new ModelAndView("buscarPlato", model);
    }

    @RequestMapping(path = "buscar-plato", method = RequestMethod.POST)
    public ModelAndView buscar(@ModelAttribute("formBuscarPlato") FormBuscarPlato busqueda) {
        ModelMap model = new ModelMap();


        List<Plato> platosPorNombre = servicioBusqueda.buscar(busqueda.getNombrePlato());

        if(platosPorNombre.isEmpty() && busqueda.getPrecio() == null && busqueda.getLocalidadRestaurante().equals("")){
            model.put("error", "Nombre de comida incorrecto, intenta de nuevo! :)");
            return new ModelAndView("buscarPlato", model);
        }

        if(busqueda.getNombrePlato() != null && busqueda.getPrecio() == null && busqueda.getLocalidadRestaurante().equals("")){
            model.put("platos",platosPorNombre);
            return new ModelAndView("buscarPlato", model);
        }

        if(busqueda.getPrecio() != null && busqueda.getLocalidadRestaurante().equals("") ){
            List<Plato> platosConFiltroPrecio = servicioBusqueda.buscar(busqueda.getPrecio());
            model.put("platosConFiltroPrecio", platosConFiltroPrecio);

            if(platosConFiltroPrecio.isEmpty() ){
                model.put("error", "No se encontraron comidas con ese precio! :(");
            }
        }

        if(!busqueda.getNombrePlato().equals("") && busqueda.getPrecio() != null && busqueda.getLocalidadRestaurante().equals("")){
            List<Plato> platosConFiltroPrecioYNombre = servicioBusqueda.buscar(busqueda.getNombrePlato(), busqueda.getPrecio());
            model.put("platosConFiltroPrecioYNombre", platosConFiltroPrecioYNombre);

            if(platosConFiltroPrecioYNombre.isEmpty()){
                model.put("error", "No se encontraron comidas con ese nombre y precio! :(");
            }
        }

        if(!busqueda.getNombrePlato().equals("") && busqueda.getPrecio() != null && !busqueda.getLocalidadRestaurante().equals("")){
            List<Plato> platosConFiltroPrecioNombreYLocalidad = servicioBusqueda.buscar(busqueda.getNombrePlato(), busqueda.getPrecio(), busqueda.getLocalidadRestaurante());
            model.put("platosConFiltroPrecioNombreYLocalidad", platosConFiltroPrecioNombreYLocalidad);

            if(platosConFiltroPrecioNombreYLocalidad.isEmpty()){
                model.put("error", "No se encontraron comidas con ese nombre y precio en la localidad seleccionada! :(");
            }
        }

        if(busqueda.getNombrePlato() != null && busqueda.getPrecio() == null && busqueda.getLocalidadRestaurante() != null){
            List<Plato> platosConFiltroNombreYLocalidad = servicioBusqueda.buscar(busqueda.getNombrePlato(), busqueda.getLocalidadRestaurante());
            model.put("platosConFiltroNombreYLocalidad", platosConFiltroNombreYLocalidad);

            if(platosConFiltroNombreYLocalidad.isEmpty()){
                model.put("error", "No se encontraron comidas con ese nombre en la localidad seleccionada! :(");
            }
        }

        if(busqueda.getPrecio() != null && busqueda.getLocalidadRestaurante() != null && busqueda.getNombrePlato().equals("")){
            List<Plato> platosConFiltroPrecioYLocalidad = servicioBusqueda.buscar(busqueda.getPrecio(), busqueda.getLocalidadRestaurante());
            model.put("platosConFiltroPrecioYLocalidad", platosConFiltroPrecioYLocalidad);
            if(platosConFiltroPrecioYLocalidad.isEmpty() && !busqueda.getLocalidadRestaurante().equals("")){
                model.put("error", "No se encontraron comidas con ese precio en la localidad seleccionada! :(");
            }
        }

        return new ModelAndView("buscarPlato", model);
    }

    @RequestMapping(path = "buscarPlatosMasVendidos", method = RequestMethod.GET)
    public ModelAndView buscarPlatosMasVendidos() {
        ModelMap model = new ModelMap();

        List<Plato> platos = servicioBusqueda.listaPlatosMasVendidos();

        model.put("platos",platos);

        return new ModelAndView("platosMasVendidos", model);
    }

}
