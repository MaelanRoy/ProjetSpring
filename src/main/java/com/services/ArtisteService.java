package com.services;

import com.dtos.ArtisteDto;

import java.util.List;

public interface ArtisteService {
    /**
     * Sauve a dog
     */
    ArtisteDto saveArtiste(ArtisteDto artisteDto);

    /**
     * Get a dog by it's id
     */
    ArtisteDto getArtisteById(int artisteId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteArtiste(int artisteId);

    /**
     * Get all the dogs
     */
    List<ArtisteDto> getAllArtiste();

    List<ArtisteDto> getArtistesByGroupe(int artisteId);
}