package com.entities;


import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    private LocalDateTime date_heure;
    private int duree;
    private float prix;


}
