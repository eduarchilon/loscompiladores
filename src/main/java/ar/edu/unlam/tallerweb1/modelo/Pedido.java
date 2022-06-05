package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pedido", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_plato")
    private List<Plato> listPlatos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
