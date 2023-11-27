package com.example.examenblancspring.controllers;

import com.example.examenblancspring.entities.Clinique;
import com.example.examenblancspring.entities.Medecin;
import com.example.examenblancspring.entities.Patient;
import com.example.examenblancspring.entities.RendezVous;
import com.example.examenblancspring.services.IService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class controller {
    private IService iService;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return iService.addClinique(clinique);
    }

    @PostMapping("/addMedecin")
    public Medecin addMedecin(@RequestBody Medecin medecin) {
        return iService.addMedecin(medecin);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return iService.addPatient(patient);
    }

    @PostMapping("/addRendezVous")
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous) {
        return iService.addRendezVous(rendezVous);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long cliniqueId){
        return iService.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }

    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin, @PathVariable Long idPatient){
        iService.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }

    @GetMapping("getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
        return iService.getNbrRendezVousMedecin(idMedecin);
    }
    }
