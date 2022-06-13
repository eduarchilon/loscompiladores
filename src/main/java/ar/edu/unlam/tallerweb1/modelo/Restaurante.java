package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante", nullable = false)
    private Long id;


    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "Horario")
    private String horario;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Calificacion")
    private Integer calificacion;


    @Column(name = "Numero_de_mesas")
    private Integer numeroDeMesas;

    @Column(name = "Localidad")
    private String localidad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getNumeroDeMesas() {
        return numeroDeMesas;
    }

    public void setNumeroDeMesas(Integer numeroDeMesas) {
        this.numeroDeMesas = numeroDeMesas;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
