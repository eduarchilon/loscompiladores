package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Reserva", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    private Date fecha;

    @ManyToMany
    private List<Plato> plato;

    public Reserva() {

    }

    public Reserva(Cliente cliente, Mesa mesa,Date fecha) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
    }

    public Reserva(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
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

