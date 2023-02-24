package com.repositories;

import com.entities.Soiree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SoireeRepository extends JpaRepository<Soiree, Integer> {
    List<Soiree> findBySalleId(int salleId);
}
