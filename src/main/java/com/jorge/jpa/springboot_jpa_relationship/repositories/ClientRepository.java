package com.jorge.jpa.springboot_jpa_relationship.repositories;

import com.jorge.jpa.springboot_jpa_relationship.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
