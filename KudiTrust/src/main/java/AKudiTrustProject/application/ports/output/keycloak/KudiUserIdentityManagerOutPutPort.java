package AKudiTrustProject.application.ports.output.keycloak;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;

public interface KudiUserIdentityManagerOutPutPort  {
    SignUpRequest createUser(SignUpRequest signUpRequest);

}
