package AKudiTrustProject.dtos.requests;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SignUpRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
