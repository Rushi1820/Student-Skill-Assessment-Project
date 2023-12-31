package Student.Skill.Assessment.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolRequest {

    @NotBlank(message = "In-valid school name")
    @JsonProperty("schoolName")
    private String name;

}
