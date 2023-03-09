package com.demo;

import com.controllers.*;
import com.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ConcertController concertController;
	@Autowired
	private ArtisteController artisteController;
	@Autowired
	private GroupeController groupeController;
	@Autowired
	private SalleController salleController;
	@Autowired
	private SoireeController soireeController;

	@Test
	void testGetArtiste() {
		// On récupère l'artiste avec l'id 1
		ArtisteDto artisteDto = artisteController.getArtiste(1);

		// On vérifie que l'artiste récupéré correspond bien a l'artiste avec l'id 1
		assertEquals(1, artisteDto.getId());
		assertEquals("Dupont", artisteDto.getNom());
		assertEquals("Jean", artisteDto.getPrenom());
		assertEquals("JD", artisteDto.getPseudo());
		assertEquals("Paris", artisteDto.getVille_origine());
		assertEquals(LocalDate.parse("1990-01-01"), artisteDto.getDate_naissance());
		System.out.println(artisteDto);
	}

	@Test
	void testGetConcert() {
		// On récupère le concert avec l'id 1
		ConcertDto concertDto = concertController.getConcert(1);

		// On vérifie que le concert récupéré correspond bien au concert avec l'id 1
		assertEquals(1, concertDto.getId());
		assertEquals(1, concertDto.getSalle_id());
		assertEquals(1, concertDto.getGroupe_id());
		assertEquals(LocalDateTime.parse("2022-03-15T20:00"), concertDto.getDate_heure());
		assertEquals(120, concertDto.getDuree());
		assertEquals(25.5, concertDto.getPrix());

		System.out.println(concertDto);
	}
	@Test
	void testGetGroupe() {
		// On récupère le groupe avec l'id 1
		GroupeDto groupeDto = groupeController.getGroupe(1);

		// On vérifie que le groupe récupéré correspond bien au groupe avec l'id 1
		assertEquals(1, groupeDto.getId());
		assertEquals("Coldplay", groupeDto.getNom());
		System.out.println(groupeDto);
	}

	@Test
	void testGetSalle() {
		// On récupère la salle avec l'id 1
		SalleDto salleDto = salleController.getSalle(1);

		// On vérifie que la salle récupérée correspond bien à la salle avec l'id 1
		assertEquals(1, salleDto.getId());
		assertEquals("Salle A", salleDto.getNom());
		assertEquals("12 Rue de la Liberté", salleDto.getAdresse());
		assertEquals(50, salleDto.getCapacite());
		assertEquals(1, salleDto.getGestionnaire_id());
		System.out.println(salleDto);
	}

	@Test
	void testGetSoiree() {
		// On récupère la soiree avec l'id 1
		SoireeDto soireeDto = soireeController.getSoiree(1);

		// On vérifie que la soiree récupérée correspond bien à la soiree avec l'id 1
		assertEquals(1, soireeDto.getId());
		assertEquals("Soirée Disco", soireeDto.getNom());
		assertEquals(20.5, soireeDto.getPrix());
		assertEquals(1, soireeDto.getSalle_id());
		System.out.println(soireeDto);
	}



}
