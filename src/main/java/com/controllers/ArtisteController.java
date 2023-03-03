package com.controllers;

import com.dtos.ArtisteDto;
import com.services.ArtisteService;
import com.services.impl.ArtisteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistes")
public class ArtisteController {

    private final ArtisteServiceImpl artisteService;

    public ArtisteController(ArtisteServiceImpl artisteService) {
        this.artisteService = artisteService;
    }

    /**
     * <p>Get all artistes in the system</p>
     * @return List<artisteDto>
     */
    @GetMapping
    public List<ArtisteDto> getArtiste() {
        return artisteService.getAllArtiste();
    }


    /**
     * Method to get the artiste based on the ID
     */
    @GetMapping("/{id}")
    public ArtisteDto getArtiste(@PathVariable int id){
        return artisteService.getArtisteById(id);
    }

    /**
     * Create a new artiste in the system
     */
    @PostMapping
    public ArtisteDto saveArtiste(final @RequestBody ArtisteDto artisteDto){
        return artisteService.saveArtiste(artisteDto);
    }

    /**
     * Delete a artiste by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteArtiste(@PathVariable int id){
        return artisteService.deleteArtiste(id);
    }
}
