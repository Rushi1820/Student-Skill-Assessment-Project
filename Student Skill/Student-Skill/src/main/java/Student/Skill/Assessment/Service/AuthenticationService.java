//package Student.Skill.Assessment.Service;
//
//import Student.Skill.Assessment.Entity.Course;
//import Student.Skill.Assessment.Entity.User;
//import Student.Skill.Assessment.Repository.CourseRepository;
//import Student.Skill.Assessment.Repository.SchoolRepository;
//import Student.Skill.Assessment.Repository.UserRepository;
//import Student.Skill.Assessment.Security.CustomUserDetailService;
//import Student.Skill.Assessment.Security.JwtService;
//import Student.Skill.Assessment.Security.UserPrinciple;
//import Student.Skill.Assessment.exceptions.ResourceNotFoundException;
//import Student.Skill.Assessment.exceptions.UnauthorizedException;
//import Student.Skill.Assessment.payload.ApiResponse;
//import Student.Skill.Assessment.payload.request.LoginRequest;
//import Student.Skill.Assessment.payload.request.UserRequest;
//import Student.Skill.Assessment.payload.response.LoginResponse;
//import Student.Skill.Assessment.utils.AppConstants;
//import Student.Skill.Assessment.utils.GenderTypes;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.bson.types.ObjectId;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class AuthenticationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//    @Autowired
//    private JwtService jwtService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private SchoolRepository schoolRepository;
//
//
//    private ModelMapper modelMapper = new ModelMapper();
//
//    @Transactional
//    public ApiResponse login(LoginRequest loginRequest) {
////        try{
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(
////                            loginRequest.getEmail(),
////                            loginRequest.getPassword()
////                    )
////            );
////        }catch (Exception e){
////            throw new UnauthorizedException(e.getMessage());
////        }
////        UserPrinciple user = (UserPrinciple)customUserDetailService.loadUserByUsername(loginRequest.getEmail());
////        String jwt = jwtService.generateToken(user);
////        LoginResponse token = LoginResponse.builder()
////                .token(jwt)
////                .build();
////        return ApiResponse.builder()
////                .success(Boolean.TRUE)
////                .errors(new ArrayList<>())
////                .message(AppConstants.LOGIN_SUCCESS)
////                .data(token)
////                .build();
////    }
//
//    @Transactional
//    public ApiResponse signUp(UserRequest userRequest) {
//        ObjectId courseId = userRequest.getCourseId(); // Convert String to ObjectId
//
//        Course course = courseRepository.findById(courseId).orElseThrow(() -> {
//            throw new ResourceNotFoundException("Course not found with Id: " + userRequest.getCourseId());
//        });
//       // SecurityQuestions securityQuestion = securityQuestionsRepository.findByIdAndActiveIndex(userRequest.getSecurityQuestionId(), true);
//        User user = modelMapper.map(userRequest, User.class);
//        user.setGender(GenderTypes.valueOf(String.valueOf(userRequest.getGender())));
//        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//        user.setCourse(courseRepository.findById(userRequest.getCourseId()).orElse(null));
//        user.setSchool(course.getSchool());
//       // user.setStatus(Status.ACTIVE);
//        user.setActiveIndex(Boolean.TRUE);
//        //user.setRoles(Arrays.asList(new Role(RoleName.STUDENT)));
//        User save = userRepository.save(user);
//        UserPrinciple userD = (UserPrinciple)customUserDetailService.loadUserByUsername(save.getEmail());
//        String jwt = jwtService.generateToken(userD);
//        LoginResponse token = LoginResponse.builder()
//                .token(jwt)
//                .build();
//        return ApiResponse.builder()
//                .success(Boolean.TRUE)
//                .errors(new ArrayList<>())
//                .message(AppConstants.SIGNUP_SUCCESS)
//                .data(token)
//                .build();
//
//    }
//
////    @Transactional
////    public ApiResponse getSecurityQuestionByUser(String  email) {
//////        User user=userRepository.findByIdAndActiveIndex(userId,true);
////        User user=userRepository.findByEmailAndActiveIndex(email, true);
////        if (user==null){
////            throw new ResourceNotFoundException("User not found with email: "+email);
////        }
////        ApiResponse apiResponse = ApiResponse.builder().data(user.getQuestion()).errors(new ArrayList<>())
////                .message(AppConstants.RETRIEVAL_SUCCESS).success(Boolean.TRUE).status(HttpStatus.OK).build();
////        return apiResponse;
////    }
////    @Transactional
////    public ApiResponse resetPassword(PasswordResetRequest passwordResetRequest) {
////        User user=userRepository.findByEmailAndActiveIndex(passwordResetRequest.getEmail(), true);
////        if (user==null){
////            throw new ResourceNotFoundException("User not found with email: "+passwordResetRequest.getEmail());
////        }
////        if(user.getQuestion().getId().equals(passwordResetRequest.getSecurityQuestionId())){
////            if(user.getSecurityAnswer().equals(passwordResetRequest.getSecurityAnswer().toLowerCase())){
////                user.setPassword(passwordEncoder.encode(passwordResetRequest.getNewPassword()));
////                userRepository.save(user);
////                return ApiResponse.builder()
////                        .data(new ArrayList<>())
////                        .status(HttpStatus.OK)
////                        .errors(new ArrayList<>())
////                        .message(AppConstants.PASSWORD_RESET_SUCCESS)
////                        .build();
////            }
////            throw new BadRequestException("Wrong security answer!");
////        }else{
////            throw new BadRequestException("Question id provided do not match the user's question id");
////        }
////
////    }
//}
//
