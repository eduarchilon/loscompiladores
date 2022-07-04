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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name ="id_plato")
    private Plato plato;


    public Carrito(Long id, Plato plato) {
        this.id = id;
        this.plato = plato;
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

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    //
//    public List<Plato> getPlatos() {
//        return platos;
//    }
//
//    public void setPlatos(List<Plato> platos) {
//        this.platos = platos;
//    }
//
//    public Boolean agregarPlatoAlPedido(Plato plato) {
//        Boolean resultado = false;
//        resultado = this.platos.add(plato);
//        return resultado;
//    }
//
//    public Boolean eliminarPlatoDelCarrito(Plato plato){
//        return this.platos.remove(plato);
//    }
}

