package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Reserva", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
    @OneToMany
    @JoinColumn(name = "id_plato")
    private List<Plato> listPlatos;

    private Date fecha;

    public Reserva() {

    }

    public Reserva(Cliente cliente, List<Plato> plato, Mesa mesa) {
        this.cliente = cliente;
        this.listPlatos = plato;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Plato> getListPlatos() {
        return listPlatos;
    }

    public void setListPlatos(List<Plato> listPlatos) {
        this.listPlatos = listPlatos;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}

