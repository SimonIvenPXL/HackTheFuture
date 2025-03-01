package eu.hackathon.utopia.controllers;


import eu.hackathon.utopia.domain.Act;
import eu.hackathon.utopia.domain.Person;
import eu.hackathon.utopia.repositories.ActRepository;
import eu.hackathon.utopia.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/act")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class actController {
    private final ActRepository actRepository;
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Act> createAct(@RequestBody actDto dto) {
        Act act = new Act();

        act.setName(dto.getName());
        act.setDescription(dto.getDescription());

        Person person = personRepository.findById(dto.getPersonId()).orElseThrow();
        act.setPerson(person);

        act.setAmountOfNutritionPoints(100);

        actRepository.save(act);

        person.setNutritionPoints(person.getNutritionPoints() + 100);
        personRepository.save(person);

        return ResponseEntity.ok(act);
    }

    @GetMapping
    public ResponseEntity<List<Act>> getAllActs() {
        List<Act> acts = actRepository.findAll();

        return ResponseEntity.ok(acts);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Act> getActById(@PathVariable Long id) {
        Act act = actRepository.findById(id).orElseThrow();

        return ResponseEntity.ok(act);
    }


}
