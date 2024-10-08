package AKudiTrustProject.application.ports.input.user_accounts;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.UpdateAccountDetailsRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.UpdateAccountDetailsResponse;

public interface UpdateAccountUseCase {
    UpdateAccountDetailsResponse updateAccount (UpdateAccountDetailsRequest updateAccountDetailsRequest);

}
