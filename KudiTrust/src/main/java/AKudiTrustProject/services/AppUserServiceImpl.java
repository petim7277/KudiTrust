package AKudiTrustProject.services;
import AKudiTrustProject.data.models.AccountType;
import AKudiTrustProject.data.models.AppAccount;
import AKudiTrustProject.data.models.AppUser;
import AKudiTrustProject.data.repositories.AppAccountRepository;
import AKudiTrustProject.data.repositories.AppUserRepository;
import AKudiTrustProject.dtos.requests.*;
import AKudiTrustProject.dtos.responses.*;
import AKudiTrustProject.exceptions.ErrorMessages;
import AKudiTrustProject.exceptions.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.exceptions.kudi_user_exceptions.KudiUserNotFoundException;
import AKudiTrustProject.mapper.KudiTrustMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Optional;

import static AKudiTrustProject.validator.KudiTrustValidator.validateFields;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService{
    private  final AppUserRepository appUserRepository;
    private  final AppAccountRepository appAccountRepository;
    private final KudiTrustMapper kudiTrustMapper;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {

        SignUpResponse signUpResponse = new SignUpResponse();
        validateFields(signUpRequest);
       Optional <AppUser> foundUser = appUserRepository.findAppUsersByEmail(signUpRequest.getEmail());
       if (foundUser.isPresent()){throw new KudiUserAlreadyExistException(ErrorMessages.KUDI_USER_ALREADY_EXIST);
       }
       AppUser savedUser = appUserRepository.save(kudiTrustMapper.toSignUpRequest(signUpRequest));
        AppAccount appAccount = new AppAccount();

        appAccount.setAccountBalance(BigDecimal.valueOf(0.0));
        appAccount.setAccountNumber(generateAccountNumber());
        appAccount.setAccountType(AccountType.valueOf(signUpRequest.getAccountType().toString().toUpperCase()));
        appAccount.setAppUser(savedUser);
        appAccountRepository.save(appAccount);
       signUpResponse.setMessage("Kudi User with username {--> "+signUpRequest.getUsername()+" }has successfully been created");
        return signUpResponse;
    }

    public static String generateAccountNumber( ) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder randomNumber = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int digit = secureRandom.nextInt(10);
            randomNumber.append(digit);
        }
        return randomNumber.toString();
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        SignInResponse signInResponse = new SignInResponse();
        Optional <AppUser> foundUser = appUserRepository.findAppUsersByEmail(signInRequest.getEmail());
        if (foundUser.isEmpty()){throw  new KudiUserNotFoundException(ErrorMessages.KUDI_USER_NOT_FOUND);}
        signInResponse.setResponse("Kudi_User with username -->> "+signInRequest.getUsername()+"has been successfully Signed in");
        return signInResponse;
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
