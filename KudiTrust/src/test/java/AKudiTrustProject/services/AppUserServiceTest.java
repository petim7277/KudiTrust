package AKudiTrustProject.services;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.domain.models.enums.AccountType;
import AKudiTrustProject.domain.services.AppUserService;
import AKudiTrustProject.domain.kudi_user_exceptions.InvalidInputFieldsException;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;

    @Test
    void signUpTest() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("jack123");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("jackwinter@gmail.com");
        userDomainObject.setFirstname("Jack");
        userDomainObject.setLastname("Winter");
        userDomainObject.setPhoneNumber("08162380765");
        userDomainObject.setAccountType(AccountType.CURRENT);
        appUserService.signUp(userDomainObject);
    }
    @Test
    void another_SignUpTest() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setFirstname("Nelson");
        userDomainObject.setLastname("Akewe");
        userDomainObject.setPassword("Password456!");
        userDomainObject.setEmail("nelsonakewe@gmail.com");
        userDomainObject.setPhoneNumber("09262280695");
        userDomainObject.setUsername("nelly123");
        userDomainObject.setAccountType(AccountType.CURRENT);
        appUserService.signUp(userDomainObject);
    }

    @Test
    void testThatAnExisting_UserCannotSignUp() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("freddie_123");
        userDomainObject.setPassword("Fred123!");
        userDomainObject.setEmail("fredlamar@gmail.com");
        userDomainObject.setFirstname("Frederick");
        userDomainObject.setLastname("Lamar");
        userDomainObject.setPhoneNumber("09162280798");
        userDomainObject.setAccountType(AccountType.CURRENT);
        assertThrows(KudiUserAlreadyExistException.class,()->appUserService.signUp(userDomainObject));
    }

   @Test
    void testThatKudiUserCan_SignUpWith_EmptyUsername_Field() {
       AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("petim@gmail.com");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
   }

   @Test
    void testThatKudiUserCan_SignUpWith_WrongUsername_Field() {
       AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("Pressy_123+");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("petim@gmail.com");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_EmptyEmail_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongEmail_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("petim@gmailcom");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }


    @Test
    void testThatKudiUserCan_SignUpWith_EmptyPassword_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("");
        userDomainObject.setEmail("petim@gmail.com");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongPassword_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("password123!");
        userDomainObject.setEmail("petim@gmailcom");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }


    @Test
    void testThatKudiUserCan_SignUpWith_EmptyPhoneNumber_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("petim@gmail.com");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongPhoneNumber_Field() {
        AppUser userDomainObject = new AppUser();
        userDomainObject.setUsername("pressy_123");
        userDomainObject.setPassword("Password123!");
        userDomainObject.setEmail("petim@gmailcom");
        userDomainObject.setFirstname("Precious");
        userDomainObject.setLastname("Etim");
        userDomainObject.setPhoneNumber("0916228079A");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(userDomainObject));
    }

    @Test
    void testAKudiUser_CanSignIn_WithoutSigningUpFirst(){
        AppUser userDomainObject = new AppUser();
        userDomainObject.setEmail("jackiewinter@gmail.com");
        assertThrows(KudiUserNotFoundException.class,()->appUserService.signIn(userDomainObject));
    }

    @Test
    void testAKudiUser_WhoHasSignedUp_CanSignIn(){
        AppUser userDomainObject = new AppUser();
        userDomainObject.setEmail("jackwinter@gmail.com");
       AppUser signedInUser =  appUserService.signIn(userDomainObject);
       assertNotNull(signedInUser);
    }

}