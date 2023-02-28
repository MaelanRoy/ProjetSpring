package com.services.impl;

import com.dtos.ConcertDto;
import com.dtos.SoireeDto;
import com.entities.Concert;
import com.entities.Salle;
import com.entities.Soiree;
import com.repositories.ConcertRepository;
import com.repositories.SalleRepository;
import com.repositories.SoireeRepository;
import com.services.ConcertService;
import com.services.SoireeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("SoireeService")
public class SoireeServiceImpl implements SoireeService {

    private final SoireeRepository soireeRepository;
    private final SalleRepository salleRepository;

    public SoireeServiceImpl(SoireeRepository soireeRepository, SalleRepository salleRepository){
        this.soireeRepository = soireeRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        // Converts the dto to the dog entity
        Soiree soiree = soireeDtoToEntity(soireeDto);
        // Save the dog entity
        soiree = soireeRepository.save(soiree);
        // Return the new dto
        return soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(int soireeId) {
        Soiree soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(int soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }

    @Override
    public List<SoireeDto> getAllSoiree() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }


    /**
     * Map dog dto to dog entity
     */
    private SoireeDto soireeEntityToDto(Soiree soiree){
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setId(soiree.getId());
        soireeDto.setNom(soiree.getNom());
        soireeDto.setPrix(soiree.getPrix());
        soireeDto.setSalle_id(soiree.getSalle().getId());
        return soireeDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Soiree soireeDtoToEntity(SoireeDto soireeDto){
        Soiree soiree = new Soiree();
        soiree.setId(soireeDto.getId());
        soiree.setNom(soireeDto.getNom());
        // récupération de l'entité Salle correspondante à partir de l'ID de la salle dans le DTO
        Salle salle = salleRepository.findById(soireeDto.getSalle_id())
                .orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        soiree.setSalle(salle);
        soiree.setPrix(soireeDto.getPrix());
        return soiree;
    }

    @Override
    public List<SoireeDto> getSoireesBySalle(int salleId) {
        List<Soiree> soirees = soireeRepository.findBySalleId(salleId);
        List<SoireeDto> soireeDtos = new ArrayList<>();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }


}
