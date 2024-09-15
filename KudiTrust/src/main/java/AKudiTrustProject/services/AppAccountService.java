package AKudiTrustProject.services;

import AKudiTrustProject.dtos.requests.CreateAccountRequest;
import AKudiTrustProject.dtos.requests.UpdateAccountDetailsRequest;
import AKudiTrustProject.dtos.requests.ViewAccountDetailsRequest;
import AKudiTrustProject.dtos.responses.CreateAccountResponse;
import AKudiTrustProject.dtos.responses.UpdateAccountDetailsResponse;
import AKudiTrustProject.dtos.responses.ViewAccountDetailsResponse;

public interface AppAccountService {
   CreateAccountResponse createAccount (CreateAccountRequest createAccountRequest);
   UpdateAccountDetailsResponse  updateAccount (UpdateAccountDetailsRequest updateAccountDetailsRequest);
   ViewAccountDetailsResponse viewAccount(ViewAccountDetailsRequest viewAccountDetailsRequest);
}
