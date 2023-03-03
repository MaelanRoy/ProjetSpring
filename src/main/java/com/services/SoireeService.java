package com.services;


import com.dtos.ConcertDto;
import com.dtos.SoireeDto;

import java.util.List;

public interface SoireeService {
    /**
     * Sauve a soiree
     */
    SoireeDto saveSoiree(SoireeDto soireeDto);

    /**
     * Get a soiree by it's id
     */
    SoireeDto getSoireeById(int soireeId);

    /**
     * Delete a soiree by it's id
     */
    boolean deleteSoiree(int soireeId);

    /**
     * Get all the soirees
     */
    List<SoireeDto> getAllSoiree();

    List<SoireeDto> getSoireesBySalle(int salleId);
}
