package sieduszewski.lukasz.CentralDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.CentralDB.Data.Dancer;

public interface DancerRepository extends JpaRepository<Dancer, Integer> {
}
