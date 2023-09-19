package Student.Skill.Assessment.Controller;

import Student.Skill.Assessment.Service.AuthenticationService;
import Student.Skill.Assessment.Service.UserService;
import Student.Skill.Assessment.payload.ApiResponse;
import Student.Skill.Assessment.payload.request.LoginRequest;
import Student.Skill.Assessment.payload.request.UserRequest;
import Student.Skill.Assessment.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AppConstants.BASE_URL+"/auth")
@Slf4j
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        log.info("/login");
        return new ResponseEntity<>(authenticationService.login(loginRequest), HttpStatus.OK);

    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody UserRequest userRequest){
        log.info("/signup");
        return new ResponseEntity<>(authenticationService.signUp(userRequest), HttpStatus.OK);

    }
//    @PostMapping("/password/reset")
//    public ResponseEntity<ApiResponse> resetPassword(@Valid @RequestBody PasswordResetRequest passwordResetRequest){
//        log.info("/password/reset");
//        ApiResponse apiResponse = authenticationService.resetPassword(passwordResetRequest);
//        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
//
//    }
//    @GetMapping("/security-question")
//    public ResponseEntity<ApiResponse> getSecurityQuestionByUser(@RequestParam String email){
//        log.info("/security-question");
//        ApiResponse apiResponse = authenticationService.getSecurityQuestionByUser(email);
//        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
//
//    }

}
