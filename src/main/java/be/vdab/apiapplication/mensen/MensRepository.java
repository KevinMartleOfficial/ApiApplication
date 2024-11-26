package be.vdab.apiapplication.mensen;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MensRepository extends JpaRepository<Mens, Long> {
    @EntityGraph(attributePaths = "todos")
    Optional<Mens> findById(long id);
}
