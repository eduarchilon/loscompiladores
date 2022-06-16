package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pedido", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_plato")
    private List<Plato> listPlatos = new LinkedList<>();

    @ManyToOne
    private Cliente cliente;

    public Pedido(Long id, List<Plato> listPlatos, Cliente cliente) {
        this.id = id;
        this.listPlatos = listPlatos;
        this.cliente = cliente;
    }

    public Pedido(){
    }

    public Pedido(List<Plato> listaPlatos, Cliente cliente) {
        this.listPlatos = listPlatos;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Plato> getListPlatos() {
        return listPlatos;
    }

    public void addPlato(Plato plato){
        listPlatos.add(plato);
    }

    public void setListPlatos(List<Plato> listPlatos) {
        this.listPlatos = listPlatos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
