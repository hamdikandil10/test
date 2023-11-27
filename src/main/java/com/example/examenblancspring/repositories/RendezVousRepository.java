package com.example.examenblancspring.repositories;

import com.example.examenblancspring.entities.RendezVous;
import com.example.examenblancspring.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    List getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    int countByMedecin_IdMedecin(Long idMedecin);

    List<RendezVous> findRendezVousByDateRDVAfter(LocalDate date);
}
