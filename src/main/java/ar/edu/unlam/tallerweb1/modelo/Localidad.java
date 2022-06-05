package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad", nullable = false)
    private Long id;

    private String descripcion;

    public Localidad(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Localidad(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
