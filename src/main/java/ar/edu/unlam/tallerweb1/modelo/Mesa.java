package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Mesa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;

    private Integer capacidad;


    public Mesa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }


}

