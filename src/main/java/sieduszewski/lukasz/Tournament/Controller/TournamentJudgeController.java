package sieduszewski.lukasz.Tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.Repository.JudgeRepository;
import sieduszewski.lukasz.Tournament.DTO.NewTournamentJudgeDTO;
import sieduszewski.lukasz.Tournament.DTO.reallyNewTournamentJudgeDTO;
import sieduszewski.lukasz.Tournament.Data.TournamentJudge;
import sieduszewski.lukasz.Tournament.Repository.TournamentJudgeRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/tournamentJudges")
public class TournamentJudgeController {

    @Autowired
    TournamentJudgeRepository tournamentJudgeRepository;

    @Autowired
    JudgeRepository judgeRepository;

    @RequestMapping("/findAll")
    public List<NewTournamentJudgeDTO> findAllTournamentJudges() {

        List<TournamentJudge> tournamentJudges = new ArrayList<>(tournamentJudgeRepository.findAll());
        List<NewTournamentJudgeDTO> newTournamentJudgeDTOS = new ArrayList<>();

        for (TournamentJudge tournamentJudge : tournamentJudges) {
            NewTournamentJudgeDTO temp = new NewTournamentJudgeDTO(tournamentJudge);
            newTournamentJudgeDTOS.add(temp);
        }

        return newTournamentJudgeDTOS;
    }

    @RequestMapping("/addJudge")
    public TournamentJudge tournamentJudge(@RequestBody reallyNewTournamentJudgeDTO newTournamentJudgeDTO) {

        TournamentJudge newTournamentJudge = new TournamentJudge();
        newTournamentJudge.setJudge(judgeRepository.findOne(newTournamentJudgeDTO.getId()));
        newTournamentJudge.setTournamentId(newTournamentJudgeDTO.getTournamentId());

        tournamentJudgeRepository.save(newTournamentJudge);

        return newTournamentJudge;
    }

}
