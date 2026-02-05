package com.jorge.jpa.springboot_jpa_relationship.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Long total;

    // @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    public Invoice() {
    }

    public Invoice(String description, Long total) {
        this.description = description;
        this.total = total;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", description=" + description + ", total=" + total + ", client=" + client + "}";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
