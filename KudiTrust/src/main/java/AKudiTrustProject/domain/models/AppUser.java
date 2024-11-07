package AKudiTrustProject.domain.models;

import AKudiTrustProject.domain.models.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.keycloak.representations.idm.UserRepresentation;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AppUser {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt = LocalDateTime.now();
    private UserRepresentation userRepresentation;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
