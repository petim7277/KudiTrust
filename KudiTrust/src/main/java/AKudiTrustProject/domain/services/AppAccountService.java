package AKudiTrustProject.domain.services;

import AKudiTrustProject.application.ports.input.user_accounts.CreateAccountUseCase;
import AKudiTrustProject.application.ports.input.user_accounts.UpdateAccountUseCase;
import AKudiTrustProject.application.ports.input.user_accounts.ViewAccountProfileUseCase;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.CreateAccountRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.UpdateAccountDetailsRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.ViewAccountDetailsRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.CreateAccountResponse;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.UpdateAccountDetailsResponse;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.ViewAccountDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public class AppAccountService implements CreateAccountUseCase, UpdateAccountUseCase, ViewAccountProfileUseCase {
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        return null;
    }

    @Override
    public UpdateAccountDetailsResponse updateAccount(UpdateAccountDetailsRequest updateAccountDetailsRequest) {
        return null;
    }

    @Override
    public ViewAccountDetailsResponse viewAccountProfile(ViewAccountDetailsRequest viewAccountDetailsRequest) {
        return null;
    }
}
