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
}
