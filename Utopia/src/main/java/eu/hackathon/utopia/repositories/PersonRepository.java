package eu.hackathon.utopia.repositories;

import eu.hackathon.utopia.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
