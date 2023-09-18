package Student.Skill.Assessment.payload.response;


import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private UUID id;

    private String firstName;
    private String lastName;

    private String userName;

    private String email;

    private String phone;

//    private String graduationYear;

    private CourseResponse course;


    private boolean activeIndex;
}
