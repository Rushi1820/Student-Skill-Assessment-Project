package Student.Skill.Assessment.payload.response;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Builder
public class SchoolResponse {
    private UUID id;
    private String name;
}
