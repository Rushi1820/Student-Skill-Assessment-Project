package Student.Skill.Assessment.payload.response;


import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {

    private UUID id;

    private String name;


    private boolean activeIndex;

}
