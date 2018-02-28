package sieduszewski.lukasz.Tournament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;

import java.util.List;

public interface TournamentCoupleRepository extends JpaRepository<TournamentCouple, Integer>{


}
