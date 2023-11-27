package com.example.examenblancspring.services;

import com.example.examenblancspring.entities.Clinique;
import com.example.examenblancspring.entities.Medecin;
import com.example.examenblancspring.entities.Patient;
import com.example.examenblancspring.entities.RendezVous;
import com.example.examenblancspring.repositories.CliniqueRepository;
import com.example.examenblancspring.repositories.MedecinRepository;
import com.example.examenblancspring.repositories.PatientRepository;
import com.example.examenblancspring.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class ServiceImp implements IService {
    private CliniqueRepository cliniqueRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepository.save(clinique);
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public RendezVous addRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId){
        medecinRepository.save(medecin);
        Clinique clinique = cliniqueRepository.findById(cliniqueId).get();
        clinique.getMedecinList().add(medecin);
        cliniqueRepository.save(clinique);
        return medecin;

    }

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient){
        Medecin medecin = medecinRepository.findById(idMedecin).get();
        Patient patient = patientRepository.findById(idPatient).get();

        rdv.setMedecin(medecin);
        rdv.setPatient(patient);

        rendezVousRepository.save(rdv);
    }

    public int getNbrRendezVousMedecin(Long idMedecin){
           return rendezVousRepository.countByMedecin_IdMedecin(idMedecin);
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void retrieveRendezVous(){
        rendezVousRepository.findRendezVousByDateRDVAfter(LocalDate.now());
    }


}
