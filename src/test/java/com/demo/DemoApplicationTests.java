package com.demo;

import com.controllers.DogController;
import com.dtos.DogDto;
import com.services.impl.DogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DogController dogController;


	@Test
	void testGetDog() {
		// On récupère le chien avec l'id 1
		DogDto dogDto = dogController.getDog(1L);

		// On vérifie que le chien récupéré correspond bien au chien avec l'id 1
		assertEquals(1L, dogDto.getId());
		assertEquals("Max", dogDto.getName());
		assertEquals("Labrador Retriever", dogDto.getRace());
		System.out.println(dogDto);
	}

}
