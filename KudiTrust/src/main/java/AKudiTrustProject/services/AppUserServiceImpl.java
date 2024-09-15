package AKudiTrustProject.services;
import AKudiTrustProject.dtos.requests.*;
import AKudiTrustProject.dtos.responses.*;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService{
    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        return null;
    }

    @Override
    public TransferMoneyResponse transferMoney(TransferMoneyRequest transferMoneyRequest) {
        return null;
    }

    @Override
    public RecieveMoneyResponse recieveMoney(RecieveMoneyRequest recieveMoneyRequest) {
        return null;
    }

    @Override
    public ViewTransactionHistoryResponse viewTransactionHistory(ViewTransactionHistoryRequest viewTransactionHistoryRequest) {
        return null;
    }

    @Override
    public UpdateAccountDetailsResponse updateAccountDetails(UpdateAccountDetailsRequest updateAccountDetailsRequest) {
        return null;
    }

    @Override
    public CancelTransactionResponse cancelTransaction(CancelTransactionRequest cancelTransactionRequest) {
        return null;
    }

    @Override
    public ViewUserDetailsResponse viewUserDetails(ViewUserDetailsRequest viewUserDetailsRequest) {
        return null;
    }

    @Override
    public ViewAccountDetailsResponse viewAccountDetails(ViewAccountDetailsRequest viewAccountDetailsRequest) {
        return null;
    }
}
