package Student.Skill.Assessment.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotBlank(message = "In-valid course name")
    private String name;
    @NotBlank(message = "In-valid course type")
    private String courseType;

}
