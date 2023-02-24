package com.entities;



import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Groupe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "groupe")
    private List<Concert> concerts = new ArrayList<>();

    @OneToMany(mappedBy = "groupe")
    private List<Artiste> artistes = new ArrayList<>();

}
