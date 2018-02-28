package sieduszewski.lukasz.Tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sieduszewski.lukasz.CentralDB.Data.Judge;
import sieduszewski.lukasz.CentralDB.Repository.JudgeRepository;
import sieduszewski.lukasz.Tournament.DTO.RoundDTO;
import sieduszewski.lukasz.Tournament.DTO.TournamentCoupleDTO;
import sieduszewski.lukasz.Tournament.DTO.TournamentJudgeRatingDTO;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;
import sieduszewski.lukasz.Tournament.Data.TournamentJudge;
import sieduszewski.lukasz.Tournament.Data.TournamentJudgeRating;
import sieduszewski.lukasz.Tournament.Repository.TournamentJudgeRatingRepository;
import sieduszewski.lukasz.Tournament.Repository.TournamentJudgeRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/tournamentJudgeRating")
public class TournamentJudgeRatingController {

    @Autowired
    TournamentJudgeRatingRepository tournamentJudgeRatingRepository;

    @Autowired
    TournamentJudgeRepository tournamentJudgeRepository;

    @Autowired
    JudgeRepository judgeRepository;

    @RequestMapping("/addRate")
    public TournamentJudgeRating tournamentJudge(@RequestBody TournamentJudgeRatingDTO tournamentJudgeRatingDTO) {

        TournamentJudgeRating tournamentJudgeRating = new TournamentJudgeRating();
        tournamentJudgeRating.setDance(tournamentJudgeRatingDTO.getDance());
        tournamentJudgeRating.setRound(tournamentJudgeRatingDTO.getRound());

        tournamentJudgeRating.setTournamentJudge(tournamentJudgeRepository.findByJudge(judgeRepository.findOne(tournamentJudgeRatingDTO.getJudgeId())));
        tournamentJudgeRating.setJudgesRating(tournamentJudgeRatingDTO.getJudgesRating());

        tournamentJudgeRatingRepository.save(tournamentJudgeRating);

        return tournamentJudgeRating;
    }

    @RequestMapping("/findRoundRate")
    public List<TournamentJudgeRating> findRoundRate(@RequestBody RoundDTO round) {

        List<TournamentJudgeRating> tournamentJudgeRatings = new ArrayList<>(tournamentJudgeRatingRepository.findAll());
        List<TournamentJudgeRating> tournamentRoundRatings = new ArrayList<>();

        for (TournamentJudgeRating tournamentJudgeRating1 : tournamentJudgeRatings) {
            if (tournamentJudgeRating1.getRound().equals(round.getRound())) {
                tournamentRoundRatings.add(tournamentJudgeRating1);
            }
        }

        return tournamentRoundRatings;
    }

}
