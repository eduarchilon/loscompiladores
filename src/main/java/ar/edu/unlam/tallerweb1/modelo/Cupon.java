package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.*;

@Entity
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cupon", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descuento")
    private Integer descuento;

    public Cupon(Long id, String nombre, Integer descuento) {
        this.id = id;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public Cupon(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
