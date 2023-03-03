package com.controllers;

import com.dtos.SalleDto;

import com.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleServiceImpl salleService;

    public SalleController(SalleServiceImpl salleService) {
        this.salleService = salleService;
    }

    /**
     * <p>Get all salles in the system</p>
     * @return List<salleDto>
     */
    @GetMapping
    public List<SalleDto> getSalle() {
        return salleService.getAllSalle();
    }

    /**
     * Method to get the salle based on the ID
     */
    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable int id){
        return salleService.getSalleById(id);
    }

    /**
     * Create a new salle in the system
     */
    @PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){
        return salleService.saveSalle(salleDto);
    }

    /**
     * Delete a salle by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable int id){
        return salleService.deleteSalle(id);
    }

}
