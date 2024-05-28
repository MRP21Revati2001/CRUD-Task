package org.example.animalproject.service;

import org.example.animalproject.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer>{

}
