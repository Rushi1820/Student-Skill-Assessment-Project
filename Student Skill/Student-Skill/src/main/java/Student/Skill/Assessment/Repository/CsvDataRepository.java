package Student.Skill.Assessment.Repository;

import Student.Skill.Assessment.Entity.CsvData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvDataRepository extends MongoRepository<CsvData, ObjectId> {
}
