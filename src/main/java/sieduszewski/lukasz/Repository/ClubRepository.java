package sieduszewski.lukasz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.Data.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    public Club findByNameLike(String name);

}
