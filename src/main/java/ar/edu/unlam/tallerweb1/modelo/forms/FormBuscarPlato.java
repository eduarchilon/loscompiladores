package ar.edu.unlam.tallerweb1.modelo.forms;

public class FormBuscarPlato {


    private Double precio;
    private String nombrePlato;
    private String localidadRestaurante;


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public String getLocalidadRestaurante() {
        return localidadRestaurante;
    }

    public void setLocalidadRestaurante(String localidadRestaurante) {
        this.localidadRestaurante = localidadRestaurante;
    }
}
