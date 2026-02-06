package com.jorge.jpa.springboot_jpa_relationship.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String lastname;

    // @JoinColumn(name = "client_id")

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "tbl_clientes_to_direcciones",
            joinColumns = @JoinColumn(name= "id_cliente"),
            inverseJoinColumns = @JoinColumn(name="id_direcciones"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"}))
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy ="client")
    private Set<Invoice> invoices;

    public Client() {
        addresses = new HashSet<>();
        invoices = new HashSet<>();
    }

    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public Client addInvoice(Invoice invoice){
        invoices.add(invoice);
        invoice.setClient(this);
        return this;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + name +
                ", lastname=" + lastname +
                ", invoices=" + invoices +
                ", addresses=" + addresses + "}";
    }

}
