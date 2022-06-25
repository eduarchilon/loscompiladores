package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_plato", nullable = false)
    private Long id_detallePlato;

    @OneToOne
    @JoinColumn(name = "id_plato")
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "id_Pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetallePedido(Plato plato, Cliente cliente) {
        this.plato = plato;
        this.cliente = cliente;
    }

    public DetallePedido() {

    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    public Long getId_detallePlato() {
        return id_detallePlato;
    }

    public void setId_detallePlato(Long id_detallePlato) {
        this.id_detallePlato = id_detallePlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
