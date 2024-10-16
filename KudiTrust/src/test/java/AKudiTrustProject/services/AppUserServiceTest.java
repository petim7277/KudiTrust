package AKudiTrustProject.services;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import AKudiTrustProject.domain.services.AppUserService;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignInRequest;
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
    @Autowired
    private AppUserRepository appUserRepository;
    @Test
    void signUpTest() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        appUserService.signUp(signUpRequest);
        assertEquals(1, appUserRepository.count());
    }
    @Test
    void anotherSignUpTest() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("freddie_123");
        signUpRequest.setPassword("Fred123!");
        signUpRequest.setEmail("fred@gmail.com");
        signUpRequest.setFirstname("Frederick");
        signUpRequest.setLastname("Lamar");
        signUpRequest.setPhoneNumber("09162280798");
        appUserService.signUp(signUpRequest);
    }

    @Test
    void testThatAnExisting_UserCannotSignUp() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(KudiUserAlreadyExistException.class,()->appUserService.signUp(signUpRequest));
    }

   @Test
    void testThatKudiUserCan_SignUpWith_WrongEmptyUsername_Field() {
       AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
   }

   @Test
    void testThatKudiUserCan_SignUpWith_WrongUsername_Field() {
       AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("Pressy_123+");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongEmptyEmail_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongEmail_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmailcom");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }


    @Test
    void testThatKudiUserCan_SignUpWith_EmptyPassword_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongPassword_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("password123!");
        signUpRequest.setEmail("petim@gmailcom");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("09162280794");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }


    @Test
    void testThatKudiUserCan_SignUpWith_EmptyPhoneNumber_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmail.com");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }

    @Test
    void testThatKudiUserCan_SignUpWith_WrongPhoneNumber_Field() {
        AppUserDomainObject signUpRequest = new AppUserDomainObject();
        signUpRequest.setUsername("pressy_123");
        signUpRequest.setPassword("Password123!");
        signUpRequest.setEmail("petim@gmailcom");
        signUpRequest.setFirstname("Precious");
        signUpRequest.setLastname("Etim");
        signUpRequest.setPhoneNumber("0916228079A");
        assertThrows(InvalidInputFieldsException.class,()->appUserService.signUp(signUpRequest));
    }

    @Test
    void testAKudiUser_CanSignIn_WithoutSigningUpFirst(){
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("pressy_123");
        signInRequest.setEmail("joan@gmail.com");
        assertThrows(KudiUserNotFoundException.class,()->appUserService.signIn(signInRequest));
    }

    @Test
    void testAKudiUser_CanSignIn_WithSigningUpFirst(){
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("pressy_123");
        signInRequest.setEmail("petim@gmail.com");
        appUserService.signIn(signInRequest);
    }

}