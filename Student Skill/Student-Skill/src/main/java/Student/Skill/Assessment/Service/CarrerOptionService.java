package Student.Skill.Assessment.Service;

import Student.Skill.Assessment.Entity.DataScientist;
import Student.Skill.Assessment.Entity.SoftwareDeveloper;
import Student.Skill.Assessment.Repository.DataScientistRepository;
import Student.Skill.Assessment.Repository.SoftwareDeveloperRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrerOptionService {
    @Autowired
    private  SoftwareDeveloperRepository softwareDeveloperRepository;
    @Autowired
    private  DataScientistRepository dataScientistRepository;


    public SoftwareDeveloper chooseSoftwareDeveloper(SoftwareDeveloper softwareDeveloper) {
        return softwareDeveloperRepository.save(softwareDeveloper);
    }

    public Optional<SoftwareDeveloper> getSoftwareDeveloper(ObjectId id) {
        return softwareDeveloperRepository.findById(id);
    }
    public DataScientist chooseDataScientist(DataScientist dataScientist) {
        return dataScientistRepository.save(dataScientist);
    }

    public Optional<DataScientist> getDataScientist(ObjectId id) {
        return dataScientistRepository.findById(id);
    }
}
