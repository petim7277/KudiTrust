package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignInRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SignInResponse;

public interface SignInUseCase {
    SignInResponse signIn(SignInRequest signInRequest);

}
