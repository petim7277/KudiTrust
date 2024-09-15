package AKudiTrustProject.services;
import AKudiTrustProject.dtos.requests.*;
import AKudiTrustProject.dtos.responses.*;


public interface AppUserService {
   SignUpResponse signUp(SignUpRequest signUpRequest);
   SignInResponse signIn(SignInRequest signInRequest);
   TransferMoneyResponse transferMoney (TransferMoneyRequest transferMoneyRequest);
   RecieveMoneyResponse recieveMoney(RecieveMoneyRequest recieveMoneyRequest);
   ViewTransactionHistoryResponse viewTransactionHistory(ViewTransactionHistoryRequest viewTransactionHistoryRequest);
   UpdateAccountDetailsResponse updateAccountDetails (UpdateAccountDetailsRequest updateAccountDetailsRequest);
   CancelTransactionResponse cancelTransaction (CancelTransactionRequest cancelTransactionRequest);
   ViewUserDetailsResponse viewUserDetails (ViewUserDetailsRequest viewUserDetailsRequest);
   ViewAccountDetailsResponse viewAccountDetails(ViewAccountDetailsRequest viewAccountDetailsRequest);
}
