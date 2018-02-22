package sieduszewski.lukasz.CentralDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.DTO.ClubDTO;
import sieduszewski.lukasz.CentralDB.Data.Club;
import sieduszewski.lukasz.CentralDB.Repository.ClubRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;


    @RequestMapping("/findAll")
    public List<ClubDTO> findAllDancers() {

        List<Club> clubs = new ArrayList<>(clubRepository.findAll());
        List<ClubDTO> clubDTOS = new ArrayList<>();

        for (Club club : clubs) {
            ClubDTO temp = new ClubDTO(club);
            clubDTOS.add(temp);
        }

        return clubDTOS;
    }

    @RequestMapping("/addClub")
    public Club club(@RequestBody ClubDTO clubDTO) {

        Club newclub = new Club();
        newclub.setName(clubDTO.getName());
        newclub.setCity(clubDTO.getCity());
        newclub.setCountry(clubDTO.getCountry());

        clubRepository.save(newclub);

        return newclub;
    }





}
