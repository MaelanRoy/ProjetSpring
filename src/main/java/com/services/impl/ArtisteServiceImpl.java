package com.services.impl;

import com.dtos.ArtisteDto;
import com.entities.Artiste;
import com.repositories.ArtisteRepository;
import com.services.ArtisteService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("ArtisteService")
public class ArtisteServiceImpl implements ArtisteService {
    private final ArtisteRepository artisteRepository;

    public ArtisteServiceImpl(ArtisteRepository artisteRepository){
        this.artisteRepository = artisteRepository;
    }

    @Override
    public ArtisteDto saveArtiste(ArtisteDto artisteDto) {
        // Converts the dto to the dog entity
        Artiste artiste = artisteDtoToEntity(artisteDto);
        // Save the dog entity
        artiste = artisteRepository.save(artiste);
        // Return the new dto
        return artisteEntityToDto(artiste);
    }

    @Override
    public ArtisteDto getArtisteById(int artisteId) {
        Artiste artiste = artisteRepository.findById(artisteId).orElseThrow(() -> new EntityNotFoundException("Artiste not found"));
        return artisteEntityToDto(artiste);
    }

    @Override
    public boolean deleteArtiste(int artisteId) {
        artisteRepository.deleteById(artisteId);
        return true;
    }

    @Override
    public List<ArtisteDto> getAllArtiste() {
        List<ArtisteDto> artisteDtos = new ArrayList<>();
        List<Artiste> artistes = artisteRepository.findAll();
        artistes.forEach(artiste -> {
            artisteDtos.add(artisteEntityToDto(artiste));
        });
        return artisteDtos;
    }

    /**
     * Map dog dto to dog entity
     */
    private ArtisteDto artisteEntityToDto(Artiste artiste){
        ArtisteDto artisteDto = new ArtisteDto();
        artisteDto.setId(artiste.getId());
        artisteDto.setNom(artiste.getNom());
        artisteDto.setPrenom(artiste.getPrenom());
        artisteDto.setPseudo(artiste.getPseudo());
        artisteDto.setVille_origine(artiste.getVille_origine());
        artisteDto.setDate_naissance(artiste.getDate_naissance());
        if (artiste.getGroupe() != null) {
            artisteDto.setGroupe_id(artiste.getGroupe().getId());
        }
        return artisteDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Artiste artisteDtoToEntity(ArtisteDto artisteDto){
        Artiste artiste = new Artiste();
        artiste.setId(artisteDto.getId());
        artiste.setNom(artisteDto.getNom());
        artiste.setPrenom(artisteDto.getPrenom());
        artiste.setPseudo(artisteDto.getPseudo());
        artiste.setVille_origine(artisteDto.getVille_origine());
        artiste.setDate_naissance(artisteDto.getDate_naissance());
        artisteDto.setGroupe_id(artiste.getGroupe() != null ? artiste.getGroupe().getId() : null);
        return artiste;
    }

    @Override
    public List<ArtisteDto> getArtistesByGroupe(int artisteId) {
        List<Artiste> artistes = artisteRepository.findByGroupeId(artisteId);
        List<ArtisteDto> artisteDtos = new ArrayList<>();
        artistes.forEach(artiste -> {
            artisteDtos.add(artisteEntityToDto(artiste));
        });
        return artisteDtos;
    }
}
