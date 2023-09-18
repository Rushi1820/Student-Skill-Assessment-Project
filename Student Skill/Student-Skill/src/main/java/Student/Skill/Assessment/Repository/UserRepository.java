package Student.Skill.Assessment.Repository;

import Student.Skill.Assessment.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    User findByEmail(String email);

    User findByUserName(String userName);

    User findByIdAndActiveIndex(UUID userId, boolean b);

    User findByEmailAndActiveIndex(String email, boolean b);
}
