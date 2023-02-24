package com.services;


import com.dtos.ConcertDto;
import com.dtos.SoireeDto;

import java.util.List;

public interface SoireeService {
    /**
     * Sauve a dog
     */
    SoireeDto saveSoiree(SoireeDto soireeDto);

    /**
     * Get a dog by it's id
     */
    SoireeDto getSoireeById(int soireeId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteSoiree(int soireeId);

    /**
     * Get all the dogs
     */
    List<SoireeDto> getAllSoiree();

    List<SoireeDto> getSoireesBySalle(int salleId);
}
