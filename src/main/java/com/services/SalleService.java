package com.services;


import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {
    /**
     * Sauve a dog
     */
    SalleDto saveSalle(SalleDto salleDto);

    /**
     * Get a dog by it's id
     */
    SalleDto getSalleById(int salleId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteSalle(int salleId);

    /**
     * Get all the dogs
     */
    List<SalleDto> getAllSalle();
}
