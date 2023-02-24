package com.entities;
import java.time.LocalDate;

import javax.persistence.*;

import com.entities.Groupe;
import lombok.Data;

@Entity
@Data
public class Artiste {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String nom;

    private  String prenom;

    private String pseudo;

    private String ville_origine;

    private LocalDate date_naissance;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

}
