package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;


@Entity
public class TipoGusto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public TipoGusto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoGusto() {
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
}
