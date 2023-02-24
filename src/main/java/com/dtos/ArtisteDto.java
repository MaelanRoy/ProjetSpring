package com.dtos;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ArtisteDto {
    private int Id;

    private String nom;

    private String prenom;

    private String pseudo;

    private String ville_origine;

    private LocalDate date_naissance;

    private int groupe_id;


}
