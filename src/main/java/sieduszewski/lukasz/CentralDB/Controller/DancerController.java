package sieduszewski.lukasz.CentralDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.Data.Dancer;
import sieduszewski.lukasz.CentralDB.Repository.DancerRepository;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/dancers")
public class DancerController {

    @Autowired
    private DancerRepository dancerRepository;

    @RequestMapping("/findAll")
    public List<Dancer> findAllDancers() {
        return dancerRepository.findAll();
    }

    @RequestMapping("/addDancer")
    public Dancer addDancer(@RequestBody Dancer dancer) {

        dancerRepository.save(dancer);

        return dancer;
    }

}
