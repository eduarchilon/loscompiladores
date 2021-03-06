package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adicional", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_tipo")
    private TipoGusto tipo;

    public Adicional(Long id, String nombre, Double precio, TipoGusto tipoGusto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipoGusto;
    }



    public Adicional() {

    }

    public Adicional(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public TipoGusto getTipo() {
        return tipo;
    }

    public void setTipo(TipoGusto tipo) {
        this.tipo = tipo;
    }
}
