package AKudiTrustProject.infrastucture.adapters.input.rest.controllers;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SignUpResponse;
import AKudiTrustProject.domain.services.AppUserService;
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
