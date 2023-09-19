package Student.Skill.Assessment.Entity;

import Student.Skill.Assessment.utils.GenderTypes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user data")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    private ObjectId id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(unique = true,name="userName")
    private String userName;
    @Column(unique = true,name="email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private GenderTypes gender;
    @Column(name="phone")
    private String phone;
    @Column(name="password")
    private String password;
    @Column(name = "grad_year")
    private String graduationYear;

    @DBRef
    private Course course;
    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "branch_id")
//    private Branch branch;
    @ManyToOne(cascade = CascadeType.ALL)
    @DBRef
    private Schools school;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    private List<Payment> payments;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Role> roles;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "question_id")
//    private SecurityQuestions question;
//    private String securityAnswer;

    @Column(name="activeIndex")
    private boolean activeIndex;
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "created_date")
    private Timestamp createdDate;
}
