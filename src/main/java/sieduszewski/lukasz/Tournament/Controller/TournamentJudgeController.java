package sieduszewski.lukasz.Tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.Repository.JudgeRepository;
import sieduszewski.lukasz.Tournament.DTO.TournamentJudgeDTO;
import sieduszewski.lukasz.Tournament.DTO.NewTournamentJudgeDTO;
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
    public List<TournamentJudgeDTO> findAllTournamentJudges() {

        List<TournamentJudge> tournamentJudges = new ArrayList<>(tournamentJudgeRepository.findAll());
        List<TournamentJudgeDTO> tournamentJudgeDTOS = new ArrayList<>();

        for (TournamentJudge tournamentJudge : tournamentJudges) {
            TournamentJudgeDTO temp = new TournamentJudgeDTO(tournamentJudge);
            tournamentJudgeDTOS.add(temp);
        }

        return tournamentJudgeDTOS;
    }

    @RequestMapping("/addJudge")
    public TournamentJudge tournamentJudge(@RequestBody NewTournamentJudgeDTO newTournamentJudgeDTO) {

        TournamentJudge newTournamentJudge = new TournamentJudge();
        newTournamentJudge.setJudge(judgeRepository.findOne(newTournamentJudgeDTO.getId()));
        newTournamentJudge.setTournamentId(newTournamentJudgeDTO.getTournamentId());

        tournamentJudgeRepository.save(newTournamentJudge);

        return newTournamentJudge;
    }

}
