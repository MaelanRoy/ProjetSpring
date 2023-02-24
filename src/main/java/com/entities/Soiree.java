package com.entities;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Soiree {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private float prix;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

}
