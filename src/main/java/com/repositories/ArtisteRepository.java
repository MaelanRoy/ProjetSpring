package com.repositories;

import com.entities.Artiste;
import com.entities.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {
    List<Artiste> findByGroupeId(int salleId);
}


