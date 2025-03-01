package eu.hackathon.utopia.controllers;


import eu.hackathon.utopia.domain.Act;
import eu.hackathon.utopia.domain.Person;
import eu.hackathon.utopia.repositories.ActRepository;
import eu.hackathon.utopia.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class personController {
    private final PersonRepository personRepository;
    private final ActRepository actRepository;

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

    @PutMapping(path = "/{actId}/upvote")
    public ResponseEntity<Act> upvoteAct(@PathVariable Long actId) {
        Act act = actRepository.findById(actId).orElseThrow(() -> new IllegalArgumentException("Could not find act"));

        // Increase the amountOfNutritionPoints for the associated person
        Person person = act.getPerson();
        person.setNutritionPoints(person.getNutritionPoints() + 1); // Increment by 1 for an upvote
        personRepository.save(person); // Save the updated person

        // Optionally, you can also update the act itself if needed
        act.setAmountOfNutritionPoints(act.getAmountOfNutritionPoints() + 1);
        actRepository.save(act);

        return ResponseEntity.ok(act); // Return the updated act
    }

}
