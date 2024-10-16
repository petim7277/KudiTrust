package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak;

import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static AKudiTrustProject.domain.validator.KudiTrustValidator.validateEmail;

@Slf4j
@RequiredArgsConstructor
public class KeycloakAdapter implements KudiUserIdentityManagerOutPutPort {

    private final Keycloak keycloak;

    private  final AppUserPersistenceMapper appUserPersistenceMapper;

    @Value("${KEYCLOAK_REALM}")
    private String keycloakRealm;

    @Override
    public AppUserDomainObject createUser(AppUserDomainObject userDomainObject) {

        if (doesEmailExist(userDomainObject.getEmail())) {
            throw new KudiUserAlreadyExistException(ErrorMessages.A_KUDI_USER_WITH_THIS_EMAIL_ALREADY_EXIST, HttpStatus.BAD_REQUEST);
        }
        UserRepresentation userRepresentation = appUserPersistenceMapper.toUserRepresentation(userDomainObject);
        userRepresentation.setEmail(userDomainObject.getEmail());
        userRepresentation.setEnabled(false);
        userRepresentation.setEmailVerified(false);
        Response response = keycloak.realm(keycloakRealm).users().create(userRepresentation);
        log.info("{} Keycloak response =====>>> ",response.readEntity(String.class));
        if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
            log.error(MarkerFactory.getMarker("FATAL"), "Error creating Kudi user with email: {}, Bad request detected, {}",
                    userDomainObject.getEmail(), response.getStatus());
        }
        Optional<AppUserDomainObject> optionalUser = getUserByEmail(userDomainObject.getEmail());
        return optionalUser.orElseThrow(()-> new KudiTrustExceptions(ErrorMessages.KUDI_USER_CREATION_FAILED,HttpStatus.valueOf(response.getStatus())));
    }

    public boolean doesEmailExist(String email) {
       validateEmail(email);
        UserRepresentation foundUser = findUserByEmail(email);
        return foundUser != null;
    }
    public UserRepresentation findUserByEmail(String email) {
        validateEmail(email);
        List<UserRepresentation> foundUsers = keycloak.realm(keycloakRealm).users().search(email);
        return foundUsers.isEmpty() ? null : foundUsers.getFirst();
    }

    public Optional<AppUserDomainObject> getUserByEmail(String email) {
        UserRepresentation userRepresentation = findUserByEmail(email);
        if (userRepresentation == null) {
            return Optional.empty();
        }
        AppUserDomainObject userDomainObject = appUserPersistenceMapper.toAppDomainObject(userRepresentation);
        userDomainObject.setUserRepresentation(userRepresentation);
        return Optional.of(userDomainObject);
    }
}
