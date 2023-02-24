package com.services.impl;
import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.ConcertService;
import com.services.SalleService;
import com.services.SoireeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("SalleService")
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;
    private final ConcertService concertService;

    private final SoireeService soireeService;


    public SalleServiceImpl(SalleRepository salleRepository, ConcertService concertServic, SoireeService soireeService){
        this.salleRepository = salleRepository;
        this.concertService = concertServic;
        this.soireeService = soireeService;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        // Converts the dto to the dog entity
        Salle salle = salleDtoToEntity(salleDto);
        // Save the dog entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(int salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleEntityToDto(salle);
    }


    @Override
    public boolean deleteSalle(int salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalle() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleEntityToDto(salle));
        });
        return salleDtos;
    }

    /**
     * Map dog dto to dog entity
     */
    private SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setNom(salle.getNom());
        salleDto.setAdresse(salle.getAdresse());
        salleDto.setCapacite(salle.getCapacite());
        salleDto.setGestionnaire_id(salle.getGestionnaire_id());
        List<ConcertDto> concerts = concertService.getConcertsBySalle(salle.getId());
        List<SoireeDto> soirees = soireeService.getSoireesBySalle(salle.getId());
        salleDto.setConcerts(concerts);
        salleDto.setSoirees(soirees);
        return salleDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Salle salleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setNom(salleDto.getNom());
        salle.setAdresse(salleDto.getAdresse());
        salle.setCapacite(salle.getCapacite());
        salle.setGestionnaire_id(salle.getGestionnaire_id());
        return salle;
    }
}
