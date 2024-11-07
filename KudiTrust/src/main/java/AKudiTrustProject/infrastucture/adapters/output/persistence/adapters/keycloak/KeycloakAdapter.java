package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak;

import AKudiTrustProject.application.ports.output.AppUserPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static AKudiTrustProject.domain.validator.KudiTrustValidator.validateEmail;

@Slf4j
@RequiredArgsConstructor
public class KeycloakAdapter implements KudiUserIdentityManagerOutPutPort {

    private final Keycloak keycloak;

    private  final AppUserPersistenceMapper appUserPersistenceMapper;

    private final AppUserPersistenceOutputPort appUserPersistenceOutputPort;

    @Value("${KEYCLOAK_REALM}")
    private String keycloakRealm;

    @Override
    public AppUser createUser(AppUser userDomainObject) {
       Optional<AppUser> foundKeyCloakUser = getUserByEmail(userDomainObject.getEmail());
        if (foundKeyCloakUser.isPresent()) {
            throw new KudiUserAlreadyExistException(ErrorMessages.KEYCLOAK_USER_ALREADY_EXIST,HttpStatus.BAD_REQUEST);
        }
        else {
            UserRepresentation userRepresentation = appUserPersistenceMapper.toUserRepresentation(userDomainObject);
            userRepresentation.setUsername(userDomainObject.getEmail());
            userRepresentation.setEnabled(true);
            userRepresentation.setUsername(userDomainObject.getUsername());
            userRepresentation.setFirstName(userRepresentation.getFirstName());
            userRepresentation.setLastName(userRepresentation.getLastName());
            userRepresentation.setCreatedTimestamp(System.currentTimeMillis());
            userRepresentation.setEmailVerified(false);
            Response response = keycloak.realm(keycloakRealm).users().create(userRepresentation);
                if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
                    log.error(MarkerFactory.getMarker("FATAL"), "Error creating Kudi user with email: {}, Bad request detected, {}",
                            userDomainObject.getEmail(), response.getStatus());
                }

            return appUserPersistenceMapper.toOptionalAppUserDomainObject(foundKeyCloakUser);
        }
    }

    public UserRepresentation findKeycloakUserByEmail(String email) {
       validateEmail(email);
       List<UserRepresentation> foundUsers = keycloak.realm(keycloakRealm).users().search(email);
       return foundUsers.get(0);
    }

    public Optional<AppUser> getUserByEmail(String email) {
        UserRepresentation userRepresentation = findKeycloakUserByEmail(email);
        if (userRepresentation == null) {
            return Optional.empty();
        }
        AppUser userDomainObject = appUserPersistenceMapper.toAppDomainObject(userRepresentation);
        userDomainObject.setUserRepresentation(userRepresentation);
        return Optional.of(userDomainObject);
    }
    @Override
    public UserRepresentation  getUserOnKeycloak(AppUser userDomainObject) {
        UserResource userResource = keycloak.realm(keycloakRealm).users().get(userDomainObject.getEmail());
        return userResource.toRepresentation();
    }
}
