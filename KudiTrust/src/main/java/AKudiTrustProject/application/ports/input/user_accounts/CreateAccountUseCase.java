package AKudiTrustProject.application.ports.input.user_accounts;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.CreateAccountRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.CreateAccountResponse;

public interface CreateAccountUseCase {
    CreateAccountResponse createAccount (CreateAccountRequest createAccountRequest);

}
