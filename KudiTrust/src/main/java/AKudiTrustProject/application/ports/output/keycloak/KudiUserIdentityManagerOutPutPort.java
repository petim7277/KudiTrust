package AKudiTrustProject.application.ports.output.keycloak;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;

public interface KudiUserIdentityManagerOutPutPort  {
    AppUserDomainObject createUser(AppUserDomainObject appUserDomainObject);

}
