package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SignUpResponse;

public interface SignUpUseCase {
    SignUpResponse signUp(SignUpRequest signUpRequest);

}
