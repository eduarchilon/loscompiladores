package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    private Calendar fecha;

    @ManyToMany
    private List<Plato> plato;

    public Reserva() {

    }

    public Reserva(Cliente cliente, Mesa mesa, Calendar fecha) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
    }

    public Reserva(Long id, Mesa mesa, Calendar fecha) {
        this.id = id;
        this.mesa = mesa;
        this.fecha = fecha;
    }

    public Reserva(Long id){
        this.id=id;
    }

    public Reserva(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Reserva(long l, Cliente cliente, Mesa mesa, Calendar fecha) {
        this.id = l;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
    }

    public Reserva(long l, Calendar date) {
        this.id =l;
        this.fecha=date;
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

    public Calendar getFecha() {
        return fecha;
    }

    public Integer getHorario() { return fecha.HOUR;}

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setMesaId(Long idMesa){
        Mesa mesa = new Mesa();
        mesa.setId(idMesa);
        setMesa(mesa);
    }

}

