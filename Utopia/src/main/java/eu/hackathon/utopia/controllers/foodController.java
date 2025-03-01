package eu.hackathon.utopia.controllers;

import eu.hackathon.utopia.domain.Food;
import eu.hackathon.utopia.domain.Person;
import eu.hackathon.utopia.repositories.FoodRepository;
import eu.hackathon.utopia.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class foodController {
    private final FoodRepository foodRepository;
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Food> createPile() {
        Food food = new Food();

        foodRepository.save(food);

        return ResponseEntity.ok(food);
    }

    @PutMapping
    public ResponseEntity<Food> addDay() {
        Food food = foodRepository.findAll().get(0);

        // Generate a random number between 8000 and 10000
        Random random = new Random();
        int randomAmount = 8000 + random.nextInt(2001); // 2001 because nextInt(2001) gives values from 0 to 2000

        food.setTotalNutritionPoints(food.getTotalNutritionPoints() + randomAmount);

        foodRepository.save(food);

        return ResponseEntity.ok(food);
    }

    @PutMapping(path = "/take")
    public ResponseEntity<Food> removeFromPile(int nutritionPoints, Long personId) {
        Food food  = foodRepository.findAll().get(0);
        Person person = personRepository.findById(personId).orElseThrow();

        if (person.getNutritionPoints() < nutritionPoints) {
            System.out.println("Invalid");
        } else {
            person.setNutritionPoints(person.getNutritionPoints() - nutritionPoints);
            food.setTotalNutritionPoints(food.getTotalNutritionPoints() - nutritionPoints);
        }

        foodRepository.save(food);
        personRepository.save(person);
        return ResponseEntity.ok(food);
    }
}
