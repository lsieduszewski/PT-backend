package sieduszewski.lukasz.Tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.Repository.CoupleRepository;
import sieduszewski.lukasz.Tournament.DTO.CoupleResultDTO;
import sieduszewski.lukasz.Tournament.DTO.NewTournamentCoupleDTO;
import sieduszewski.lukasz.Tournament.DTO.TournamentCoupleDTO;
import sieduszewski.lukasz.Tournament.Data.TournamentCouple;
import sieduszewski.lukasz.Tournament.Data.TournamentJudgeRating;
import sieduszewski.lukasz.Tournament.Repository.TournamentCoupleRepository;
import sieduszewski.lukasz.Tournament.Repository.TournamentJudgeRatingRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.reverse;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/tournamentCouples")
public class TournamentCoupleController {

    @Autowired
    private TournamentCoupleRepository tournamentCoupleRepository;

    @Autowired
    private CoupleRepository coupleRepository;

    @Autowired
    private TournamentJudgeRatingRepository tournamentJudgeRatingRepository;


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

    @RequestMapping("/findAllInTournamentBack")
    public List<TournamentCouple> findAllInTournamentCouplesBack() {

        List<TournamentCouple> tournamentCouples = new ArrayList<>(tournamentCoupleRepository.findAll());
        List<TournamentCouple> tournamentCouple2 = new ArrayList<>();

        for (TournamentCouple tournamentCouple : tournamentCouples) {
            if (tournamentCouple.isInTournament()) {
                tournamentCouple2.add(tournamentCouple);
            }
        }

        return tournamentCouple2;
    }

    @RequestMapping("/findAllInTournament")
    public List<TournamentCoupleDTO> findAllInTournamentCouples() {

        List<TournamentCouple> tournamentCouples = new ArrayList<>(tournamentCoupleRepository.findAll());
        List<TournamentCoupleDTO> tournamentCoupleDTOS = new ArrayList<>();

        for (TournamentCouple tournamentCouple : tournamentCouples) {
            TournamentCoupleDTO temp = new TournamentCoupleDTO(tournamentCouple);
            if (tournamentCouple.isInTournament()) {
                tournamentCoupleDTOS.add(temp);
            }
        }

        return tournamentCoupleDTOS;
    }

    @RequestMapping("/findCoupleResult")
    public List<CoupleResultDTO> coupleResultDTOS() {

        List<TournamentCouple> tournamentCouples = new ArrayList<>(tournamentCoupleRepository.findAll());
        List<CoupleResultDTO> coupleResultDTOS = new ArrayList<>();

        for (TournamentCouple tournamentCouple : tournamentCouples) {
            CoupleResultDTO temp = new CoupleResultDTO(tournamentCouple);
            coupleResultDTOS.add(temp);
        }

        return coupleResultDTOS;
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

    @RequestMapping("/addRoundPoints")
    public List<TournamentCouple> tournamentCoupleAddPoints(@RequestBody List<TournamentJudgeRating> tournamentJudgeRating) {

        List<TournamentCouple> tournamentCouples = findAllInTournamentCouplesBack();


        for (TournamentCouple tournamentCouple1 : tournamentCouples) {
            tournamentCouple1.setRoundPoint(0);
        }


        Comparator<TournamentCouple> t = Comparator.comparing(TournamentCouple::getStartNumber);
        tournamentCouples.sort(t);

        for (TournamentJudgeRating tournamentJudgeRating1 : tournamentJudgeRating) {
            String[] tempRate = tournamentJudgeRating1.getJudgesRating().split("");

            for (int i = 0; i < tempRate.length; i++) {
                if (true) {
                    Integer rate = parseInt(tempRate[i]);
                    TournamentCouple temp = tournamentCoupleRepository.findOne(tournamentCouples.get(i).getId());
                    temp.setRoundPoint(temp.getRoundPoint() + rate);
                    tournamentCoupleRepository.save(temp);
                }
            }
        }

        //ustawianie wynikow rundy, zmiana inTournament i wstawianie place
        Integer tempSize = tournamentCouples.size();

        Comparator<TournamentCouple> t2 = Comparator.comparing((TournamentCouple::getRoundPoint));

        if (tempSize > 6) {
            tournamentCouples.sort(t2.reversed());
        } else {
            tournamentCouples.sort(t2);
        }


        Integer start;

        if (tempSize <= 6) {
            start = 0;
        } else if (tempSize > 6 && tempSize <= 13) {
            start = 6;
        } else {
            start = 12;
        }

        for (int i = start; i < tournamentCouples.size(); i++) {
            TournamentCouple temp = tournamentCoupleRepository.findOne(tournamentCouples.get(i).getId());
            temp.setInTournament(false);
            temp.setPlace(i+1);
            tournamentCoupleRepository.save(temp);
        }

        return tournamentCouples;
    }


}
