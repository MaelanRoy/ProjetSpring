package com.dtos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConcertDto {
    private int Id;
    private int salle_id;
    private int groupe_id;
    private LocalDateTime date_heure;
    private int duree;
    private float prix;

}
