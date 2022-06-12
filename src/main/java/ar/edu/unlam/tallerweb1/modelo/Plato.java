package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.enums.TipoPlato;

import javax.persistence.*;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato", nullable = false)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Tipo_plato")
    private Enum TIPO_PLATO;


    @Column(name ="cantVentas")
    private Integer cantVentas;

    @ManyToOne
    private Restaurante restaurante;


    public Plato(Long id, Enum TIPO_PLATO, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.TIPO_PLATO = TIPO_PLATO;
    }
    public Plato( Enum TIPO_PLATO, String nombre, Integer cantVentas) {
        this.nombre = nombre;
        this.TIPO_PLATO = TIPO_PLATO;
        this.cantVentas = cantVentas;
    }
    public Plato(){

    }

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Enum getTIPO_PLATO() {
        return TIPO_PLATO;
    }

    public void setTIPO_PLATO(Enum TIPO_PLATO) {
        this.TIPO_PLATO = TIPO_PLATO;
    }

    public void setCantVentas(Integer cantVentas) {
        this.cantVentas = cantVentas;
    }

    public Integer getCantVentas() {
        return cantVentas;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
