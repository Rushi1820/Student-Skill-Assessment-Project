package Student.Skill.Assessment.Repository;

import Student.Skill.Assessment.Entity.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CourseRepository extends MongoRepository<Course, ObjectId> {


}
