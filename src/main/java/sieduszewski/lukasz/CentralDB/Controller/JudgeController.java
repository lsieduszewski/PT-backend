package sieduszewski.lukasz.CentralDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sieduszewski.lukasz.CentralDB.DTO.JudgeDTO;
import sieduszewski.lukasz.CentralDB.Data.Judge;
import sieduszewski.lukasz.CentralDB.Repository.JudgeRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/judges")
public class JudgeController {

    @Autowired
    private JudgeRepository judgeRepository;


    @RequestMapping("/findAll")
    public List<JudgeDTO> findAllJudges() {

        List<Judge> judges = new ArrayList<>(judgeRepository.findAll());
        List<JudgeDTO> judgeDTOS = new ArrayList<>();

        for (Judge judge : judges) {
            JudgeDTO temp = new JudgeDTO(judge);
            judgeDTOS.add(temp);
        }

        return judgeDTOS;
    }

    @RequestMapping("/addJudge")
    public Judge judge (@RequestBody JudgeDTO judgeDTO) {

        Judge newjudge = new Judge();
        newjudge.setSurname(judgeDTO.getSurname());
        newjudge.setName(judgeDTO.getName());
        newjudge.setCity(judgeDTO.getCity());
        newjudge.setCountry(judgeDTO.getCountry());

        judgeRepository.save(newjudge);

        return newjudge;
    }

}
