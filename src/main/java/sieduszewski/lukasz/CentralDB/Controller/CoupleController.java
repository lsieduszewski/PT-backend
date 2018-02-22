package sieduszewski.lukasz.CentralDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.DTO.CoupleDTO;
import sieduszewski.lukasz.CentralDB.DTO.newCoupleDTO;
import sieduszewski.lukasz.CentralDB.Data.Couple;
import sieduszewski.lukasz.CentralDB.Repository.ClubRepository;
import sieduszewski.lukasz.CentralDB.Repository.CoupleRepository;
import sieduszewski.lukasz.CentralDB.Repository.DancerRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/couples")
public class CoupleController {

    @Autowired
    private CoupleRepository coupleRepository;

    @Autowired
    private DancerRepository dancerRepository;

    @Autowired
    private ClubRepository clubRepository;


    @RequestMapping("/addCouple")
    public Couple couple(@RequestBody newCoupleDTO newCoupleDTO) {

        Couple newcouple = new Couple();
        newcouple.setMale(dancerRepository.findOne(newCoupleDTO.getMale()));
        newcouple.setFemale(dancerRepository.findOne(newCoupleDTO.getFemale()));
        newcouple.setClub(clubRepository.findOne(newCoupleDTO.getClub()));

        coupleRepository.save(newcouple);

        return newcouple;
    }

    @RequestMapping("/findAll")
    public List<CoupleDTO> findAllDancers() {

        List<Couple> couples = new ArrayList<>(coupleRepository.findAll());
        List<CoupleDTO> coupleDTOS = new ArrayList<>();

        for (Couple couple : couples) {
            CoupleDTO temp = new CoupleDTO(couple);
            coupleDTOS.add(temp);
        }

        return coupleDTOS;
    }




}
