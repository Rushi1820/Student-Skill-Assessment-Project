package Student.Skill.Assessment.payload.request;

import Student.Skill.Assessment.utils.GenderTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotBlank(message = "Invalid first name")
    private String firstName;

    @NotBlank(message = "Invalid last name")
    private String lastName;

    @NotBlank(message = "Invalid username")
    private String userName;

    @Email(message = "Invalid email",regexp = "[a-z0-9._%+-]+@woxsen+\\.edu.in",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotNull(message = "In-valid gender")
    private GenderTypes gender;

    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phone;

    @NotBlank(message = "In-valid password")
    private String password;
////    @JsonProperty("graduationYear")
////    @NotNull(message = "In-valid graduation year")
//    private String graduationYear;
    @NotNull
    private ObjectId courseId;
//    @NotNull
//    private UUID SecurityQuestionId;
//    @NotBlank(message = "In-valid answer")
//    private String securityAnswer;
}
