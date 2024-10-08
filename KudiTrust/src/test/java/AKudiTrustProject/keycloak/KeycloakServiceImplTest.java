package AKudiTrustProject.keycloak;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class KeycloakServiceImplTest {
   @Autowired
   private KudiUserIdentityAdapter keycloakService;

    @Test
    void createUser() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setFirstname("Gabriel");
        signUpRequest.setLastname("Kudi");
        signUpRequest.setUsername("username");
        signUpRequest.setPassword("password");
        signUpRequest.setEmail("gabriel.kudi@gmail.com");
        signUpRequest.setPhoneNumber("09162250691");


    }
}