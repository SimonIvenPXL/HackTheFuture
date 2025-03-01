package eu.hackathon.utopia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "acts")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int amountOfNutritionPoints;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false) // Ensure nullable=false is needed
    private Person person;
}
