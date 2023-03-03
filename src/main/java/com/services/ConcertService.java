package com.services;

import com.dtos.ConcertDto;

import java.util.List;

public interface ConcertService {
    /**
     * Sauve a concert
     */
    ConcertDto saveConcert(ConcertDto concertDto);

    /**
     * Get a concert by it's id
     */
    ConcertDto getConcertById(int concertId);

    /**
     * Delete a concert by it's id
     */
    boolean deleteConcert(int concertId);

    /**
     * Get all the concerts
     */
    List<ConcertDto> getAllConcert();

    List<ConcertDto> getConcertsBySalle(int salleId);


}
