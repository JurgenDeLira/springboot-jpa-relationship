package com.jorge.jpa.springboot_jpa_relationship.repositories;

import com.jorge.jpa.springboot_jpa_relationship.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long>{
    @Query("select c from Client c join fetch c.addresses")
    Optional<Client> findOne(Long id);
}
