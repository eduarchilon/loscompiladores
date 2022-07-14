package ar.edu.unlam.tallerweb1.modelo;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class CarritoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carritoAdicional", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name ="id_adicional")
    private Adicional adicional;

    public CarritoAdicional(Long id, Adicional adicional) {
        this.id = id;
        this.adicional = adicional;
    }

    public CarritoAdicional(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adicional getAdicional() {
        return adicional;
    }

    public void setAdicional(Adicional adicional) {
        this.adicional = adicional;
    }

    public void setAdicionalId(Long idCarritoAdicional) {
        Adicional ad1 = new Adicional();
        ad1.setId(idCarritoAdicional);
        setAdicional(ad1);
    }
}
