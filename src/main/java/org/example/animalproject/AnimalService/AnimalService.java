package org.example.animalproject.AnimalService;

import java.util.List;
import java.util.Optional;

import org.example.animalproject.entity.Animal;
import org.example.animalproject.service.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<org.example.animalproject.model.Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(org.example.animalproject.model.Animal animal) {
        return animalRepository.saveAll(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteAllById(id);
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findAllById(id);
    }
}

