package com.repositories;

import com.entities.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConcertRepository extends JpaRepository<Concert, Integer> {
    List<Concert> findBySalleId(int salleId);
}
