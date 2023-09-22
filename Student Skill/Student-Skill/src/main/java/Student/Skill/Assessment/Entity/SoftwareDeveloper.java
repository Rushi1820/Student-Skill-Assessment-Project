package Student.Skill.Assessment.Entity;

import Student.Skill.Assessment.utils.SoftwareRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "software_developers")
public class SoftwareDeveloper {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private SoftwareRole role;


}
