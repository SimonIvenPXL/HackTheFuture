package eu.hackathon.utopia.repositories;

import eu.hackathon.utopia.domain.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {

}
