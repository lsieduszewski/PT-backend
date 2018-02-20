package sieduszewski.lukasz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.DTO.ClubDTO;
import sieduszewski.lukasz.DTO.CoupleDTO;
import sieduszewski.lukasz.DTO.newCoupleDTO;
import sieduszewski.lukasz.Data.Club;
import sieduszewski.lukasz.Data.Couple;
import sieduszewski.lukasz.Repository.ClubRepository;
import sieduszewski.lukasz.Repository.CoupleRepository;
import sieduszewski.lukasz.Repository.DancerRepository;

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




}
