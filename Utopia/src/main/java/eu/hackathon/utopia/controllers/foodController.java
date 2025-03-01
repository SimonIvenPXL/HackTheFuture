package eu.hackathon.utopia.controllers;

import eu.hackathon.utopia.domain.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class foodController {

    @PostMapping
    public ResponseEntity<Food> addDay() {
        Food food = new Food();

        // Generate a random number between 8000 and 10000
        Random random = new Random();
        int randomAmount = 8000 + random.nextInt(2001); // 2001 because nextInt(2001) gives values from 0 to 2000

        food.setAmount(randomAmount);

        return ResponseEntity.ok(food);
    }
}
