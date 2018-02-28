package sieduszewski.lukasz.Tournament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sieduszewski.lukasz.CentralDB.Data.Judge;
import sieduszewski.lukasz.Tournament.Data.TournamentJudge;

public interface TournamentJudgeRepository extends JpaRepository<TournamentJudge, Integer> {

    public TournamentJudge findByJudge(Judge judge);

}
