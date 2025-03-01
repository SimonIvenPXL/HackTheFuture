package eu.hackathon.utopia.controllers;


import eu.hackathon.utopia.domain.Person;
import eu.hackathon.utopia.repositories.ActRepository;
import eu.hackathon.utopia.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class personController {
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody personDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setNutritionPoints(0);

        personRepository.save(person);

        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(person);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Person> addPoints(@PathVariable Long id, @RequestBody int nutritionPoints) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not find person"));
        person.setNutritionPoints(person.getNutritionPoints() + nutritionPoints);
        personRepository.save(person);
        return ResponseEntity.ok(person);
    }

}
