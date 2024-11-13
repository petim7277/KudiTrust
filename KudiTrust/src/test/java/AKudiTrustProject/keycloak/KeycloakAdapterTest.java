package AKudiTrustProject.keycloak;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak.KeycloakAdapter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
@SpringBootTest
class KeycloakAdapterTest {
   @Autowired
   private  KeycloakAdapter keycloakAdapter;



    @Test
    void test_CreateUser() {
            AppUser userDomainObject = new AppUser();
            userDomainObject.setFirstname("Jameson");
            userDomainObject.setLastname("Peters");
            userDomainObject.setPassword("password");
            userDomainObject.setEmail("jamesonpeters@gmail.com");
            userDomainObject.setPhoneNumber("09262280695");
            userDomainObject.setUsername("jamie");
            keycloakAdapter.createUser(userDomainObject);
    }

    @Test
    void test_DeleteUser() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setEmail("jamesonpeters@gmail.com");
    keycloakAdapter.deleteUser(userDomainObject);

    }



}