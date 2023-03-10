package com.controllers;

import com.dtos.GroupeDto;
import com.dtos.SalleDto;
import com.services.impl.GroupeServiceImpl;
import com.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/groupes")
public class GroupeController {
    private final GroupeServiceImpl groupeService;

    public GroupeController(GroupeServiceImpl groupeService) {
        this.groupeService = groupeService;
    }

    /**
     * <p>Get all groupes in the system</p>
     * @return List<groupeDto>
     */
    @GetMapping
    public List<GroupeDto> getGroupe() {
        return groupeService.getAllGroupe();
    }

    /**
     * Method to get the groupe based on the ID
     */
    @GetMapping("/{id}")
    public GroupeDto getGroupe(@PathVariable int id){
        return groupeService.getGroupeById(id);
    }

    /**
     * Create a new groupe in the system
     */
    @PostMapping
    public GroupeDto saveGroupe(final @RequestBody GroupeDto groupeDto){
        return groupeService.saveGroupe(groupeDto);
    }

    /**
     * Delete a groupe by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteGroupe(@PathVariable int id){
        return groupeService.deleteGroupe(id);
    }
}
