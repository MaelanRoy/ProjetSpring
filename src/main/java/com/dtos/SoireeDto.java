package com.dtos;
import lombok.Data;

@Data
public class SoireeDto {
    private int Id;
    private String nom;
    private float prix;
    private int salle_id;

}
