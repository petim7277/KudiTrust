package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SignUpResponse;

public interface SignUpUseCase {
    AppUserDomainObject signUp(AppUserDomainObject domainObject);

}
