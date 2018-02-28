package sieduszewski.lukasz.Tournament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.Tournament.Data.TournamentJudgeRating;

public interface TournamentJudgeRatingRepository extends JpaRepository<TournamentJudgeRating, Integer> {

  }
