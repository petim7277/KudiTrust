package AKudiTrustProject.infrastucture.adapters.input.rest.data.requests;

import AKudiTrustProject.domain.models.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import org.keycloak.representations.idm.UserRepresentation;

@Getter
@Setter
public class SignUpRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private AccountType accountType;
    private UserRepresentation userRepresentation;
}
