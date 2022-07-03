package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito", nullable = false)
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name ="id_plato")
    private List<Plato> platos =  new LinkedList<>();


    public Carrito(Long id, List<Plato> platos) {
        this.id = id;
        this.platos = platos;
    }

    public Carrito(){

    }

    public Carrito(Long idCarrito) {
        this.id = idCarrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    public Boolean agregarPlatoAlPedido(Plato plato) {
        Boolean resultado = false;
        resultado = this.platos.add(plato);
        return resultado;
    }

    public Boolean eliminarPlatoDelCarrito(Plato plato){
        return this.platos.remove(plato);
    }
}

