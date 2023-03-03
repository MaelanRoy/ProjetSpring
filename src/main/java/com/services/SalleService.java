package com.services;


import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {
    /**
     * Sauve a salle
     */
    SalleDto saveSalle(SalleDto salleDto);

    /**
     * Get a salle by it's id
     */
    SalleDto getSalleById(int salleId);

    /**
     * Delete a salle by it's id
     */
    boolean deleteSalle(int salleId);

    /**
     * Get all the salles
     */
    List<SalleDto> getAllSalle();
}
