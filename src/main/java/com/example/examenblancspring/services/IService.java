package com.example.examenblancspring.services;

import com.example.examenblancspring.entities.*;

import java.util.List;

public interface IService {
    Clinique addClinique(Clinique clinique);
    Medecin addMedecin(Medecin medecin);
    Patient addPatient(Patient patient);
    RendezVous addRendezVous(RendezVous rendezVous);

    Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);

    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    // List getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    public int getNbrRendezVousMedecin(Long idMedecin);

    public void retrieveRendezVous();


}
