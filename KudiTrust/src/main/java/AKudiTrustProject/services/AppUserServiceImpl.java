package AKudiTrustProject.services;
import AKudiTrustProject.data.models.AppUser;
import AKudiTrustProject.data.repositories.AppUserRepository;
import AKudiTrustProject.dtos.requests.*;
import AKudiTrustProject.dtos.responses.*;
import AKudiTrustProject.exceptions.ErrorMessages;
import AKudiTrustProject.exceptions.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.exceptions.kudi_user_exceptions.KudiUserNotFoundException;
import AKudiTrustProject.mapper.KudiTrustMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static AKudiTrustProject.validator.KudiTrustValidator.validateFields;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService{
    private  final AppUserRepository appUserRepository;
    private final KudiTrustMapper kudiTrustMapper;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = new SignUpResponse();
        validateFields(signUpRequest);
       Optional <AppUser> foundUser = appUserRepository.findAppUsersByEmail(signUpRequest.getEmail());
       if (foundUser.isPresent()){throw new KudiUserAlreadyExistException(ErrorMessages.KUDI_USER_ALREADY_EXIST);
       }
       appUserRepository.save(kudiTrustMapper.toSignUpRequest(signUpRequest));
       signUpResponse.setMessage("Kudi User with username {--> "+signUpRequest.getUsername()+" }has successfully been created");
        return signUpResponse;
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
