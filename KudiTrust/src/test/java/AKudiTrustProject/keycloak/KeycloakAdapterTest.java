package AKudiTrustProject.keycloak;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak.KeycloakAdapter;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@AllArgsConstructor
@SpringBootTest
class KeycloakAdapterTest {

   private final KeycloakAdapter keycloakAdapter;

    @Test
    void createUser() {
        AppUserDomainObject userDomainObject = new AppUserDomainObject();
        userDomainObject.setFirstname("Gabriel");
        userDomainObject.setLastname("Kudi");
        userDomainObject.setUsername("username");
        userDomainObject.setPassword("password");
        userDomainObject.setEmail("gabrielkudi@gmail.com");
        userDomainObject.setPhoneNumber("09162250691");
        keycloakAdapter.createUser(userDomainObject);

    }
}