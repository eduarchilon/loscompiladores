package ar.edu.unlam.tallerweb1.modelo.forms;

public class FormBuscarPlato {


    private Double precio;
    private String nombrePlato;
    private String localidadRestaurante;
    private String nombrePlatoElegido;
    private Enum tipoPlatoElegido;
    private String descripcionPlatoElegido;
    private String nombreRestauranteElegido;
    private String localidadRestauranteElegido;
    private Double precioPlatoELegido;

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

    public String getNombrePlatoElegido() {
        return nombrePlatoElegido;
    }

    public void setNombrePlatoElegido(String nombrePlatoElegido) {
        this.nombrePlatoElegido = nombrePlatoElegido;
    }

    public Enum getTipoPlatoElegido() {
        return tipoPlatoElegido;
    }

    public void setTipoPlatoElegido(Enum tipoPlatoElegido) {
        this.tipoPlatoElegido = tipoPlatoElegido;
    }

    public String getDescripcionPlatoElegido() {
        return descripcionPlatoElegido;
    }

    public void setDescripcionPlatoElegido(String descripcionPlatoElegido) {
        this.descripcionPlatoElegido = descripcionPlatoElegido;
    }

    public String getNombreRestauranteElegido() {
        return nombreRestauranteElegido;
    }

    public void setNombreRestauranteElegido(String nombreRestauranteElegido) {
        this.nombreRestauranteElegido = nombreRestauranteElegido;
    }

    public Double getPrecioPlatoELegido() {
        return precioPlatoELegido;
    }

    public void setPrecioPlatoELegido(Double precioPlatoELegido) {
        this.precioPlatoELegido = precioPlatoELegido;
    }

    public String getLocalidadRestauranteElegido() {
        return localidadRestauranteElegido;
    }

    public void setLocalidadRestauranteElegido(String localidadRestauranteElegido) {
        this.localidadRestauranteElegido = localidadRestauranteElegido;
    }
}
