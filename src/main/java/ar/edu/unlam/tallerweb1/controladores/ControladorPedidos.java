package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ControladorPedidos {


    @RequestMapping(path = "/pedidos-clientes", method = RequestMethod.GET)
    public ModelAndView verTodosLosPedidos(){
        ModelMap modelo = new ModelMap();
        return null;
    }
}
