//package AKudiTrustProject.keycloak;
//
//import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
//import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
//import AKudiTrustProject.domain.exceptions.ErrorMessages;
//import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;
//import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
//import AKudiTrustProject.domain.mapper.KudiTrustMapper;
//import AKudiTrustProject.domain.validator.KudiTrustValidator;
//import jakarta.ws.rs.core.Response;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.representations.idm.UserRepresentation;
//import org.slf4j.MarkerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class KudiUserIdentityAdapter implements KudiUserIdentityManagerOutPutPort {
//
//    private final Keycloak keycloak;
//
//    @Value("${KEYCLOAK_REALM}")
//    private String keycloakRealm;
//
//    private  final KudiTrustMapper kudiTrustMapper;
//
//    @Override
//    public SignUpRequest createUser(SignUpRequest signUpRequest) {
//
//
//        if (doesEmailExist(signUpRequest.getEmail())) {
//            throw new KudiUserAlreadyExistException(ErrorMessages.A_KUDI_USER_WITH_THIS_EMAIL_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
//        }
//        UserRepresentation userRepresentation = kudiTrustMapper.toUserRepresentation(signUpRequest);
//        userRepresentation.setUsername(signUpRequest.getEmail());
//        userRepresentation.setEnabled(false);
//        userRepresentation.setEmailVerified(false);
//        Response response = keycloak.realm(keycloakRealm).users().create(userRepresentation);
//        log.info(response.readEntity(String.class));
//        if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
//            log.error(MarkerFactory.getMarker("FATAL"), "Error creating user with email: {}, Bad request detected, {}",
//                    signUpRequest.getEmail(), response.getStatus());
//        }
//        Optional<SignUpRequest> optionalUser = getUserByEmail(signUpRequest.getEmail());
//        return optionalUser.orElseThrow(()-> new KudiTrustExceptions(ErrorMessages.KUDI_USER_CREATION_FAILED,HttpStatus.valueOf(response.getStatus())));
//    }
//
//    public boolean doesEmailExist(String email) {
//        KudiTrustValidator.validateEmail(email);
//        UserRepresentation foundUser = findUserByEmail(email);
//        return foundUser != null;
//    }
//    public UserRepresentation findUserByEmail(String email) {
//        KudiTrustValidator.validateEmail(email);
//        List<UserRepresentation> foundUsers = keycloak.realm(keycloakRealm).users().search(email);
//        return foundUsers.isEmpty() ? null : foundUsers.get(0);
//    }
//
//    public Optional<SignUpRequest> getUserByEmail(String email) {
//        UserRepresentation userRepresentation = findUserByEmail(email);
//        if (userRepresentation == null) {
//            return Optional.empty();
//        }
//        SignUpRequest signUpRequest = kudiTrustMapper.toSignUpRequest(userRepresentation);
//        signUpRequest.setUserRepresentation(userRepresentation);
//        return Optional.of(signUpRequest);
//    }
//}
