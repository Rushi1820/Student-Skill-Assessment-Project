package Student.Skill.Assessment.Repository;

import Student.Skill.Assessment.Entity.SoftwareDeveloper;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareDeveloperRepository extends MongoRepository<SoftwareDeveloper, ObjectId> {

}
