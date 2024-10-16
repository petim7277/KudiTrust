package AKudiTrustProject.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.keycloak.representations.idm.UserRepresentation;

import java.time.LocalDateTime;

@Getter
@Setter

public class AppUserDomainObject {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt = LocalDateTime.now();
    private AppAccountDomainObject appAccount;
    private UserRepresentation userRepresentation;


}
