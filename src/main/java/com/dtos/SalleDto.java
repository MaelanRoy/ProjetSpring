package com.dtos;


import lombok.Data;

import java.util.List;


@Data
public class SalleDto {
    private int Id;
    private String nom;
    private String adresse;
    private int capacite;
    private int gestionnaire_id;

    List<ConcertDto> concerts;

    List<SoireeDto> soirees;
}
