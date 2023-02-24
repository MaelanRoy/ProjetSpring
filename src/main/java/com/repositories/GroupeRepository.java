package com.repositories;

import com.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

}
