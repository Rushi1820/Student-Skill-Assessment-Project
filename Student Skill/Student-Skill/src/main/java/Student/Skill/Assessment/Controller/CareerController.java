package Student.Skill.Assessment.Controller;

import Student.Skill.Assessment.Entity.DataScientist;
import Student.Skill.Assessment.Entity.SoftwareDeveloper;
import Student.Skill.Assessment.Service.CarrerOptionService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/v1/career")
public class CareerController {
    @Autowired
    private CarrerOptionService  Service;

    private static final Logger logger = LoggerFactory.getLogger(CareerController.class);


    @PostMapping("/software-developer")
    public SoftwareDeveloper chooseSoftwareDeveloper(@RequestBody SoftwareDeveloper softwareDeveloper) {
        logger.info("adding student as a Software-developer ");
        return Service.chooseSoftwareDeveloper(softwareDeveloper);
    }

    @GetMapping("/software-developer/{id}")
    public Optional<SoftwareDeveloper> getSoftwareDeveloper(@PathVariable ObjectId id) {
        logger.info("getting student info as a Software-developer ");
        return Service.getSoftwareDeveloper(id);
    }

    @PostMapping("/data-scientist")
    public DataScientist chooseDataScientist(@RequestBody DataScientist dataScientist) {
        logger.info("adding student as a DataScientist ");
        return Service.chooseDataScientist(dataScientist);
    }

    @GetMapping("/data-scientist/{id}")
    public Optional<DataScientist> getDataScientist(@PathVariable ObjectId id) {
        logger.info("getting student info as a Data Scientist ");
        return Service.getDataScientist(id);
    }
}

