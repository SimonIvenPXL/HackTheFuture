package eu.hackathon.utopia.controllers;

import eu.hackathon.utopia.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class actDto {
    private String name;
    private String description;
    private int amountOfNutritionPoints;
    private Long personId;
}
