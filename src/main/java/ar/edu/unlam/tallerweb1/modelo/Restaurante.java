package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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


    //TO DO: el campo este sobra
    @Column(name = "Numero_de_mesas")
    private Integer numeroDeMesas;

    @Column(name = "Localidad")
    private String localidad;
    @Column(name = "HorarioApertura")
    private Integer horarioApertura;

    public Integer getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(Integer horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public Integer getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(Integer horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    @Column(name = "HorarioCierre")
    private Integer horarioCierre;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesas")
    private List<Mesa> listMesa;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localidad")
    private Localidad locacion;

    public Restaurante(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Restaurante(Long id, Localidad locacion) {
        this.id = id;
        this.locacion = locacion;
    }

    public Restaurante(){

    }

    public List<Mesa> getListMesa() {
        return listMesa;
    }

    public void setListMesa(List<Mesa> listMesa) {
        this.listMesa = listMesa;
    }

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
