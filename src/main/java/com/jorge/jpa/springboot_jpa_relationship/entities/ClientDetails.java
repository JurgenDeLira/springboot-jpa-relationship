package com.jorge.jpa.springboot_jpa_relationship.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="clients_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean premium;
    private Integer point;

    @OneToOne
    @JoinColumn(name = "id_cliente_detalle")
    private Client client;


    public ClientDetails(boolean premium, Integer point) {
        this.premium = premium;
        this.point = point;
    }

    @Override
    public String toString() {
        return
                "{id=" + id +
                ", premium=" + premium +
                ", point=" + point +
                '}';
    }
}
