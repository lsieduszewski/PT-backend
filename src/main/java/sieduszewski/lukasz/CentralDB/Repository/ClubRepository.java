package sieduszewski.lukasz.CentralDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.CentralDB.Data.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    public Club findByNameLike(String name);

}
