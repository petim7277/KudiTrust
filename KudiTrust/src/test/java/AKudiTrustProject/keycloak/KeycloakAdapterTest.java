package AKudiTrustProject.keycloak;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak.KeycloakAdapter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class KeycloakAdapterTest {
   @Autowired
   private  KeycloakAdapter keycloakAdapter;



    @Test
    void test_CreateUser() {
            AppUser userDomainObject = new AppUser();
            userDomainObject.setFirstname("Nelson");
            userDomainObject.setLastname("Akewe");
            userDomainObject.setPassword("password");
            userDomainObject.setEmail("nelsonakewe@gmail.com");
            userDomainObject.setPhoneNumber("09262280695");
            userDomainObject.setUsername("nelly");
            keycloakAdapter.createUser(userDomainObject);
    }

    @Test
    void test_GetUser() {
        AppUser userDomainObject = new AppUser();

        userDomainObject.setEmail("nelsonakewe@gmail.com");

    }



}