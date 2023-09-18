package Student.Skill.Assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudentSkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSkillApplication.class, args);
	}

}
