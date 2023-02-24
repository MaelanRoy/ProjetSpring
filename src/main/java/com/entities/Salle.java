package com.entities;



import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Salle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private int capacite;
    private int gestionnaire_id;

    @OneToMany(mappedBy = "salle")
    private List<Concert> concerts = new ArrayList<>();

    @OneToMany(mappedBy = "salle")
    private List<Soiree> soirees = new ArrayList<>();

}
