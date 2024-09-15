package AKudiTrustProject.controllers;
import AKudiTrustProject.dtos.requests.SignUpRequest;
import AKudiTrustProject.dtos.responses.SignUpResponse;
import AKudiTrustProject.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/AppUserController/")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;
    @PostMapping ("KudiSignUp")
    public ResponseEntity<SignUpResponse> signUpKudiUser(SignUpRequest signUpRequest){
        SignUpResponse response = appUserService.signUp(signUpRequest);
        return ResponseEntity.ok(response) ;
    }
    @GetMapping("/")
    public  String greet() {
        return "Hello World";
    }
}
