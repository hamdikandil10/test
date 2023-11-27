package com.example.examenblancspring.repositories;

import com.example.examenblancspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
