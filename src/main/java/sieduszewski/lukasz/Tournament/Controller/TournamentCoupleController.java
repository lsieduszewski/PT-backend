package sieduszewski.lukasz.Tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.Repository.CoupleRepository;
import sieduszewski.lukasz.Tournament.DTO.NewTournamentCoupleDTO;
import sieduszewski.lukasz.Tournament.DTO.TournamentCoupleDTO;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;
import sieduszewski.lukasz.Tournament.Repository.TournamentCoupleRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/tournamentCouples")
public class TournamentCoupleController {

    @Autowired
    private TournamentCoupleRepository tournamentCoupleRepository;

    @Autowired
    private CoupleRepository coupleRepository;


    @RequestMapping("/findAll")
    public List<TournamentCoupleDTO> findAllTournamentCouples() {

        List<TournamentCouple> tournamentCouples = new ArrayList<>(tournamentCoupleRepository.findAll());
        List<TournamentCoupleDTO> tournamentCoupleDTOS = new ArrayList<>();

        for (TournamentCouple tournamentCouple : tournamentCouples) {
            TournamentCoupleDTO temp = new TournamentCoupleDTO(tournamentCouple);
            tournamentCoupleDTOS.add(temp);
        }

        return tournamentCoupleDTOS;
    }

    @RequestMapping("/addTournamentCouple")
    public TournamentCouple tournamentCouple(@RequestBody NewTournamentCoupleDTO newTournamentCoupleDTO) {

        TournamentCouple newTournamentCouple = new TournamentCouple();
        newTournamentCouple.setCouple(coupleRepository.findOne(newTournamentCoupleDTO.getId()));
        newTournamentCouple.setStartNumber(newTournamentCoupleDTO.getStartNumber());
        newTournamentCouple.setInTournament(true);

        tournamentCoupleRepository.save(newTournamentCouple);

        return newTournamentCouple;
    }


}
