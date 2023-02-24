package com.controllers;

import com.dtos.SoireeDto;
import com.services.impl.SoireeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {

    private final SoireeServiceImpl soireeService;

    public SoireeController(SoireeServiceImpl soireeService) {
        this.soireeService = soireeService;
    }

    /**
     * <p>Get all dogs in the system</p>
     * @return List<DogDto>
     */
    @GetMapping
    public List<SoireeDto> getSoire() {return soireeService.getAllSoiree();
    }


    /**
     * Method to get the dog based on the ID
     */
    @GetMapping("/{id}")
    public SoireeDto getSoiree(@PathVariable int id){
        return soireeService.getSoireeById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public SoireeDto saveSoiree(final @RequestBody SoireeDto soireeDto){
        return soireeService.saveSoiree(soireeDto);
    }

    /**
     * Delete a dog by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSoiree(@PathVariable int id){
        return soireeService.deleteSoiree(id);
    }

}
