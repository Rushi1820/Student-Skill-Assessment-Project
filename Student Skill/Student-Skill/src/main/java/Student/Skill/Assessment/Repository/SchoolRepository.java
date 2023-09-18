package Student.Skill.Assessment.Repository;

import Student.Skill.Assessment.Entity.Schools;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SchoolRepository extends MongoRepository<Schools, UUID> {
}
