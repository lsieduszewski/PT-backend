package sieduszewski.lukasz.Tournament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.Tournament.Data.TournamentJudge;

public interface TournamentJudgeRepository extends JpaRepository<TournamentJudge, Integer> {

}
