package com.jorge.jpa.springboot_jpa_relationship.repositories;

import com.jorge.jpa.springboot_jpa_relationship.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
