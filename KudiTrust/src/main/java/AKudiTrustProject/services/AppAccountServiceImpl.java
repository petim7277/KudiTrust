package AKudiTrustProject.services;

import AKudiTrustProject.dtos.requests.CreateAccountRequest;
import AKudiTrustProject.dtos.requests.UpdateAccountDetailsRequest;
import AKudiTrustProject.dtos.requests.ViewAccountDetailsRequest;
import AKudiTrustProject.dtos.responses.CreateAccountResponse;
import AKudiTrustProject.dtos.responses.UpdateAccountDetailsResponse;
import AKudiTrustProject.dtos.responses.ViewAccountDetailsResponse;
import org.springframework.stereotype.Service;

@Service
public class AppAccountServiceImpl implements AppAccountService{
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        return null;
    }

    @Override
    public UpdateAccountDetailsResponse updateAccount(UpdateAccountDetailsRequest updateAccountDetailsRequest) {
        return null;
    }

    @Override
    public ViewAccountDetailsResponse viewAccount(ViewAccountDetailsRequest viewAccountDetailsRequest) {
        return null;
    }
}
