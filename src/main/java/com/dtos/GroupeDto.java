package com.dtos;
import lombok.Data;

import java.util.List;

@Data
public class GroupeDto {
    private int Id;
    private String nom;

    List<ConcertDto> concerts;

    List<ArtisteDto> artistes;

}
