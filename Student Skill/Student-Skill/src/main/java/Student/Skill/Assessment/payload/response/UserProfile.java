package Student.Skill.Assessment.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {

	private UUID id;

	private String firstName;
	private String lastName;

	private String userName;

	private String email;

	private String phone;

	private String graduationYear;

	private CourseResponse course;



	private boolean activeIndex;

}
