package sieduszewski.lukasz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.DTO.newCoupleDTO;
import sieduszewski.lukasz.Data.Couple;
import sieduszewski.lukasz.Repository.CoupleRepository;
import sieduszewski.lukasz.Repository.DancerRepository;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/couples")
public class CoupleController {

    @Autowired
    private CoupleRepository coupleRepository;

    @Autowired
    private DancerRepository dancerRepository;

    @RequestMapping("/addCouple")
    public Couple couple(@RequestBody newCoupleDTO newCoupleDTO) {

        Couple newcouple = new Couple();
        newcouple.setMale(dancerRepository.findOne(newCoupleDTO.getMale()));
        newcouple.setFemale(dancerRepository.findOne(newCoupleDTO.getFemale()));


        coupleRepository.save(newcouple);

        return  newcouple;
    }
}
