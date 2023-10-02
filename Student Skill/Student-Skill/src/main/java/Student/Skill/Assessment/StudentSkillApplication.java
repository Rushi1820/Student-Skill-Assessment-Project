package Student.Skill.Assessment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@OpenAPIDefinition
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudentSkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSkillApplication.class, args);
	}

}
