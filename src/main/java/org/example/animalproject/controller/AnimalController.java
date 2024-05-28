package org.example.animalproject.controller;

import java.util.List;

import org.example.animalproject.AnimalService.AnimalService;
import org.example.animalproject.model.Animal;
import org.example.animalproject.service.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.tools.javac.util.StringUtils;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public String listAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animalList";
    }

    @GetMapping("/animal/new")
    public String createAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animalForm";
    }

    @PostMapping("/animal/save")
    public String saveAnimal(@ModelAttribute Animal animal, @RequestParam("file") MultipartFile file) {
        // Handle file upload
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        animal.setImageUrl(fileName);
        // Save file to a location
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/animal/edit/{id}")
    public String editAnimalForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id).orElseThrow(() -> new IllegalArgumentException("Invalid animal Id:" + id));
        model.addAttribute("animal", animal);
        return "animalForm";
    }

    @GetMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }
}

