package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.controladores.ControladorBusqueda;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.forms.FormBuscarPlato;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ControladorBusquedaTest {

    public static final String VISTA_BUSQUEDA = "buscarPlato";
    public static final String NOMBRE_VALIDO = "Empanada";
    public static final String NOMBRE_INVALIDO = "Silla";
    public static final String LOCALIDAD_VALIDA = "Ciudadela";
    public static final String LOCALIDAD_INVALIDA = "Castelar";
    public static final Double PRECIO_VALIDO = 1000.00;
    public static final Double PRECIO_INVALIDO = 10.00;


    private ControladorBusqueda controladorBusqueda;
    private ServicioBusqueda servicioBusqueda;


    @Before
    public void init(){
        servicioBusqueda = mock(ServicioBusqueda.class);
        controladorBusqueda = new ControladorBusqueda(servicioBusqueda);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElNombreBuscado(){
        dadoQueExisteUnPlatoConNombre(NOMBRE_VALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConNombre(NOMBRE_VALIDO);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConNombreBuscado(){
        dadoQueNoExisteUnPlatoConNombre(NOMBRE_INVALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConNombre(NOMBRE_INVALIDO);

        entoncesRegresoALaVistaBusquedaConMensajeError("Nombre de comida incorrecto, intenta de nuevo! :)", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElPrecioBuscado(){
        dadoQueExisteUnPlatoConPrecio(PRECIO_VALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecio(PRECIO_VALIDO);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConPrecioBuscado(){
        dadoQueNoExisteUnPlatoConPrecio(PRECIO_INVALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecio(PRECIO_INVALIDO);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas con ese precio! :(", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElNombreYPrecioBuscado(){
        dadoQueExisteUnPlatoConPrecioYNombre(PRECIO_VALIDO, NOMBRE_VALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioYNombre(PRECIO_INVALIDO, NOMBRE_INVALIDO);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConPrecioYNombreBuscado(){
        dadoQueNoExisteUnPlatoConPrecioYNombre(PRECIO_INVALIDO, NOMBRE_INVALIDO);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioYNombre(PRECIO_INVALIDO, NOMBRE_INVALIDO);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas con ese nombre y precio! :(", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElNombrePrecioYLocalidadBuscado(){
        dadoQueExisteUnPlatoConPrecioNombreYLocalidad(PRECIO_VALIDO, NOMBRE_VALIDO,LOCALIDAD_VALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioNombreYLocalidad(PRECIO_VALIDO, NOMBRE_VALIDO, LOCALIDAD_VALIDA);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConPrecioNombreYLocalidadBuscado(){
        dadoQueNoExisteUnPlatoConPrecioNombreYLocalidad(PRECIO_INVALIDO, NOMBRE_INVALIDO, LOCALIDAD_INVALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioNombreYLocalidad(PRECIO_INVALIDO, NOMBRE_INVALIDO, LOCALIDAD_INVALIDA);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas con ese nombre y precio en la localidad seleccionada! :(", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElNombreYLocalidadBuscado(){
        dadoQueExisteUnPlatoConNombreYLocalidad(NOMBRE_VALIDO,LOCALIDAD_VALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConNombreYLocalidad(NOMBRE_VALIDO, LOCALIDAD_VALIDA);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConNombreYLocalidadBuscado(){
        dadoQueNoExisteUnPlatoConNombreYLocalidad(NOMBRE_INVALIDO, LOCALIDAD_INVALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConNombreYLocalidad(NOMBRE_INVALIDO, LOCALIDAD_INVALIDA);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas con ese nombre en la localidad seleccionada! :(", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConElPrecioYLocalidadBuscado(){
        dadoQueExisteUnPlatoConPrecioYLocalidad(PRECIO_VALIDO,LOCALIDAD_VALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioYLocalidad(PRECIO_VALIDO, LOCALIDAD_VALIDA);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraPlatoConPrecioYLocalidadBuscado(){
        dadoQueNoExisteUnPlatoConPrecioYLocalidad(PRECIO_INVALIDO, LOCALIDAD_INVALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConPrecioYLocalidad(PRECIO_INVALIDO, LOCALIDAD_INVALIDA);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas con ese precio en la localidad seleccionada! :(", mav);

    }

    @Test
    public void retornaListaDePlatosQueCoincidanConLocalidadBuscado(){
        dadoQueExisteUnPlatoConLocalidad(LOCALIDAD_VALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConLocalidad(LOCALIDAD_VALIDA);

        entoncesRegresoALaVistaBusquedaConPlatos(VISTA_BUSQUEDA, mav);
    }

    @Test
    public void retornaErrorSiNoEncuentraLocalidadBuscado(){
        dadoQueNoExisteUnPlatoConLocalidad(LOCALIDAD_INVALIDA);

        ModelAndView mav = cuandoBuscoUnPlatoConLocalidad(LOCALIDAD_INVALIDA);

        entoncesRegresoALaVistaBusquedaConMensajeError("No se encontraron comidas en la localidad seleccionada! :(", mav);

    }

    private void dadoQueNoExisteUnPlatoConLocalidad(String localidadInvalida) {
        when(servicioBusqueda.buscar(localidadInvalida, localidadInvalida)).thenReturn(new LinkedList());
    }


    private void dadoQueExisteUnPlatoConLocalidad(String localidadValida) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(localidadValida)).thenReturn(platos);
    }


    private void dadoQueNoExisteUnPlatoConPrecioYLocalidad(Double precioInvalido, String localidadInvalida) {
        when(servicioBusqueda.buscar(precioInvalido, localidadInvalida)).thenReturn(new LinkedList());
    }

    private void dadoQueExisteUnPlatoConPrecioYLocalidad(Double precioValido, String localidadValida) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(precioValido,localidadValida)).thenReturn(platos);
    }


    private void dadoQueNoExisteUnPlatoConNombreYLocalidad(String nombreInvalido, String localidadInvalida) {
        when(servicioBusqueda.buscar(nombreInvalido, localidadInvalida)).thenReturn(new LinkedList());
    }


    private void dadoQueExisteUnPlatoConNombreYLocalidad(String nombreValido, String localidadValida) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombreValido,localidadValida)).thenReturn(platos);
    }


    private void dadoQueNoExisteUnPlatoConPrecioNombreYLocalidad(Double precioInvalido, String nombreInvalido, String localidadInvalida) {
        when(servicioBusqueda.buscar(nombreInvalido,precioInvalido, localidadInvalida)).thenReturn(new LinkedList());
    }


    private void dadoQueExisteUnPlatoConPrecioNombreYLocalidad(Double precioValido, String nombreValido, String localidadValida) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombreValido,precioValido, localidadValida)).thenReturn(platos);
    }



    private void dadoQueExisteUnPlatoConPrecioYNombre(Double precioValido, String nombreValido) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombreValido,precioValido)).thenReturn(platos);
    }


    private void dadoQueNoExisteUnPlatoConPrecio(Double precioInvalido) {
        when(servicioBusqueda.buscar(precioInvalido)).thenReturn(new LinkedList());
    }

    private void dadoQueNoExisteUnPlatoConPrecioYNombre(Double precioInvalido, String nombreValido) {
        when(servicioBusqueda.buscar(precioInvalido, nombreValido)).thenReturn(new LinkedList());
    }


    private void dadoQueExisteUnPlatoConNombre(String nombrePlato) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(nombrePlato)).thenReturn(platos);
    }

    private void dadoQueNoExisteUnPlatoConNombre(String nombrePlato) {
        when(servicioBusqueda.buscar(nombrePlato)).thenReturn(new LinkedList());
    }

    private void dadoQueExisteUnPlatoConPrecio(Double precio) {
        List <Plato> platos = new LinkedList<>();
        when(servicioBusqueda.buscar(precio)).thenReturn(platos);
    }


    private ModelAndView cuandoBuscoUnPlatoConNombre(String nombrePlato) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato(nombrePlato);
        form.setLocalidadRestaurante("");
        return controladorBusqueda.buscar(form);
    }

    private ModelAndView cuandoBuscoUnPlatoConNombreYLocalidad(String nombreValido, String localidadValida) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato(nombreValido);
        form.setLocalidadRestaurante(localidadValida);
        return controladorBusqueda.buscar(form);
    }

    private ModelAndView cuandoBuscoUnPlatoConLocalidad(String localidadValida) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato("");
        form.setLocalidadRestaurante(localidadValida);
        return controladorBusqueda.buscar(form);
    }

    private ModelAndView cuandoBuscoUnPlatoConPrecio(Double precio) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato("");
        form.setPrecio(precio);
        form.setLocalidadRestaurante("");
        return controladorBusqueda.buscar(form);
    }


    private ModelAndView cuandoBuscoUnPlatoConPrecioYLocalidad(Double precioValido, String localidadValida) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato("");
        form.setPrecio(precioValido);
        form.setLocalidadRestaurante(localidadValida);
        return controladorBusqueda.buscar(form);
    }

    private ModelAndView cuandoBuscoUnPlatoConPrecioNombreYLocalidad(Double precioValido, String nombreValido, String localidadValida) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato(nombreValido);
        form.setPrecio(precioValido);
        form.setLocalidadRestaurante(localidadValida);
        return controladorBusqueda.buscar(form);
    }

    private ModelAndView cuandoBuscoUnPlatoConPrecioYNombre(Double precioValido, String nombreValido) {
        FormBuscarPlato form = new FormBuscarPlato();
        form.setNombrePlato(nombreValido);
        form.setPrecio(precioValido);
        form.setLocalidadRestaurante("");
        return controladorBusqueda.buscar(form);

    }


    private void entoncesRegresoALaVistaBusquedaConPlatos(String nombreVista, ModelAndView mav) {
        List <Plato> platos = (List<Plato>) mav.getModel().get("platos");
        assertThat(mav.getViewName()).isEqualTo(nombreVista);
        assertThat(mav.getModel().get("platos")).isEqualTo(platos);
    }

    private void entoncesRegresoALaVistaBusquedaConMensajeError(String error, ModelAndView mav) {
    assertThat(mav.getViewName()).isEqualTo("buscarPlato");
    assertThat(mav.getModel().get("error")).isEqualTo(error);
    }






}
