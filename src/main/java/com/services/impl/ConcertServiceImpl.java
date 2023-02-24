package com.services.impl;

import com.dtos.ConcertDto;
import com.entities.Concert;
import com.entities.Salle;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("ConcertService")
public class ConcertServiceImpl implements ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        // Converts the dto to the dog entity
        Concert concert = concertDtoToEntity(concertDto);
        // Save the dog entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return concertEntityToDto(concert);
    }

    @Override
    public ConcertDto getConcertById(int concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(int concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcert() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }

    /**
     * Map dog dto to dog entity
     */
    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());
        concertDto.setSalle_id(concert.getSalle().getId());
        concertDto.setGroupe_id(concert.getGroupe().getId());
        concertDto.setDate_heure(concert.getDate_heure());
        concertDto.setDuree(concertDto.getDuree());
        concertDto.setPrix(concertDto.getPrix());
        return concertDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Concert concertDtoToEntity(ConcertDto concertDto){
        Concert concert = new Concert();
        concert.getSalle().setId(concertDto.getSalle_id());
        concert.setId(concertDto.getId());
        concert.getGroupe().setId(concertDto.getGroupe_id());
        concert.setDate_heure(concertDto.getDate_heure());
        concert.setDuree(concertDto.getDuree());
        concert.setPrix(concertDto.getPrix());
        return concert;
    }

    @Override
    public List<ConcertDto> getConcertsBySalle(int salleId) {
        List<Concert> concerts = concertRepository.findBySalleId(salleId);
        List<ConcertDto> concertDtos = new ArrayList<>();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }
}