package com.example.examenblancspring.repositories;

import com.example.examenblancspring.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> {
}
