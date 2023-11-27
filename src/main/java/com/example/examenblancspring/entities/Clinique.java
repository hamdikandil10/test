package com.example.examenblancspring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClinique;

    private String nomClinique;

    private String adresse;

    private int telephone;

    @ManyToMany
    private List<Medecin> medecinList;

}
