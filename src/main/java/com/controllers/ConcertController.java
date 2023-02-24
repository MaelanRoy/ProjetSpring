package com.controllers;

import com.dtos.ConcertDto;
import com.services.impl.ConcertServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {

    private final ConcertServiceImpl concertService;

    public ConcertController(ConcertServiceImpl concertService) {
        this.concertService = concertService;
    }

    /**
     * <p>Get all dogs in the system</p>
     * @return List<DogDto>
     */
    @GetMapping
    public List<ConcertDto> getConcert() {
        return concertService.getAllConcert();
    }


    /**
     * Method to get the dog based on the ID
     */
    @GetMapping("/{id}")
    public ConcertDto getConcert(@PathVariable int id){
        return concertService.getConcertById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public ConcertDto saveConcert(final @RequestBody ConcertDto concertDto){
        return concertService.saveConcert(concertDto);
    }

    /**
     * Delete a dog by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteConcert(@PathVariable int id){
        return concertService.deleteConcert(id);
    }

}
