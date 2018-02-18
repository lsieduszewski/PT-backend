package sieduszewski.lukasz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.Data.Dancer;

public interface DancerRepository extends JpaRepository<Dancer, Integer> {
}
