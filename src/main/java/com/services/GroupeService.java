package com.services;


import com.dtos.GroupeDto;

import java.util.List;

public interface GroupeService {
    /**
     * Sauve a dog
     */
    GroupeDto saveGroupe(GroupeDto groupeDto);

    /**
     * Get a dog by it's id
     */
    GroupeDto getGroupeById(int groupeId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteGroupe(int groupeId);

    /**
     * Get all the dogs
     */
    List<GroupeDto> getAllGroupe();
}
