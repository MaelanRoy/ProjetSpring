package com.services.impl;
import com.dtos.ArtisteDto;
import com.dtos.ConcertDto;
import com.dtos.GroupeDto;
import com.entities.Groupe;
import com.repositories.GroupeRepository;
import com.services.ArtisteService;
import com.services.ConcertService;
import com.services.GroupeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service("GroupeService")
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository groupeRepository;
    private final ConcertService concertService;
    private final ArtisteService artisteService;


    public GroupeServiceImpl(GroupeRepository groupeRepository, ConcertService concertService, ArtisteService artisteService){
        this.groupeRepository = groupeRepository;
        this.concertService = concertService;
        this.artisteService = artisteService;
    }

    @Override
    public GroupeDto saveGroupe(GroupeDto groupeDto) {
        // Converts the dto to the groupe entity
        Groupe groupe = groupeDtoToEntity(groupeDto);
        // Save the groupe entity
        groupe = groupeRepository.save(groupe);
        // Return the new dto
        return groupeEntityToDto(groupe);
    }

    @Override
    public GroupeDto getGroupeById(int groupeId) {
        Groupe groupe = groupeRepository.findById(groupeId).orElseThrow(() -> new EntityNotFoundException("Groupe not found"));
        return groupeEntityToDto(groupe);
    }


    @Override
    public boolean deleteGroupe(int groupeId) {
        groupeRepository.deleteById(groupeId);
        return true;
    }

    @Override
    public List<GroupeDto> getAllGroupe() {
        List<GroupeDto> groupeDtos = new ArrayList<>();
        List<Groupe> groupes = groupeRepository.findAll();
        groupes.forEach(groupe -> {
            groupeDtos.add(groupeEntityToDto(groupe));
        });
        return groupeDtos;
    }

    /**
     * Map groupe dto to groupe entity
     */
    private GroupeDto groupeEntityToDto(Groupe groupe){
        GroupeDto groupeDto = new GroupeDto();
        groupeDto.setId(groupe.getId());
        groupeDto.setNom(groupe.getNom());
        List<ConcertDto> concerts = concertService.getConcertsBySalle(groupe.getId());
        List<ArtisteDto> artistes = artisteService.getArtistesByGroupe(groupe.getId());
        groupeDto.setConcerts(concerts);
        groupeDto.setArtistes(artistes);
        return groupeDto;
    }

    /**
     * Map groupe entity to groupe dto
     */
    private Groupe groupeDtoToEntity(GroupeDto groupeDto){
        Groupe groupe = new Groupe();
        groupe.setId(groupeDto.getId());
        groupe.setNom(groupeDto.getNom());
        return groupe;
    }
}
