package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.exception.IdentityManagerException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserPersistenceAdapterTest {

  @Autowired
  private AppUserPersistenceAdapter appUserPersistenceAdapter;

    @Test
    void test_SaveUser() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setFirstname("Nelson");
        userDomainObject.setLastname("Akewe");
        userDomainObject.setPassword("password");
        userDomainObject.setEmail("nelsonakewe@gmail.com");
        userDomainObject.setPhoneNumber("09262280695");
        userDomainObject.setUsername("nelly");
        appUserPersistenceAdapter.saveUser(userDomainObject);

    }



    @Test
    void test_FindUserByEmail() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setFirstname("Nelson");
        userDomainObject.setLastname("Akewe");
        userDomainObject.setPassword("password");
        userDomainObject.setEmail("nelsonakewe@gmail.com");
        userDomainObject.setPhoneNumber("09262280695");
        userDomainObject.setUsername("nelly");
        appUserPersistenceAdapter.findUserByEmail(userDomainObject.getEmail());

    }

    @Test
    void test_FindUserByEmailWith_NonExistentEmail() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setFirstname("Jacob");
        userDomainObject.setLastname("Miller");
        userDomainObject.setPassword("password");
        userDomainObject.setEmail("jacobmiller@gmail.com");
        userDomainObject.setPhoneNumber("08261280665");
        userDomainObject.setUsername("milly");
        assertThrows(IdentityManagerException.class,()-> appUserPersistenceAdapter.findUserByEmail(userDomainObject.getEmail()));
    }
}