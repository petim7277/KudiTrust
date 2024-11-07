package AKudiTrustProject.application.ports.output.keycloak;

import AKudiTrustProject.domain.models.AppUser;
import org.keycloak.representations.idm.UserRepresentation;

public interface KudiUserIdentityManagerOutPutPort  {
    AppUser createUser(AppUser appUserDomainObject);

    UserRepresentation getUserOnKeycloak(AppUser userDomainObject);
}
