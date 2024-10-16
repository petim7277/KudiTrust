package AKudiTrustProject.domain.services;
import AKudiTrustProject.application.ports.input.user_accounts.ViewAccountProfileUseCase;
import AKudiTrustProject.application.ports.input.users.*;
import AKudiTrustProject.application.ports.output.AppAccountPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.AppUserPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
import AKudiTrustProject.domain.models.enums.AccountType;
import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserNotFoundException;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.*;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Optional;

import static AKudiTrustProject.domain.validator.KudiTrustValidator.*;

@AllArgsConstructor
@Service
public class AppUserService implements SignUpUseCase, SignInUseCase, TransferMoneyUsecase, RecieveMoneyUseCase,
                                        CancelTransactionUseCase,ViewUserProfileUseCase,ViewAccountProfileUseCase{
    private  final AppUserRepository appUserRepository;
    private final AppUserPersistenceOutputPort userPersistenceOutputPort;
    private final AppAccountPersistenceOutputPort appAccountPersistenceOutputPort;
    private final KudiUserIdentityManagerOutPutPort kudiUserIdentityManagerOutPutPort;
    @Override
    public AppUserDomainObject signUp(AppUserDomainObject domainObject) {
        validateFields(domainObject);
        Optional<AppUserDomainObject> foundUser = Optional.ofNullable(userPersistenceOutputPort.findUserByEmail(domainObject.getEmail())
                .orElseThrow(() -> new KudiUserAlreadyExistException(ErrorMessages.KUDI_USER_ALREADY_EXIST, HttpStatus.BAD_REQUEST)));
        kudiUserIdentityManagerOutPutPort.createUser(foundUser.orElseThrow(()-> new KudiUserNotFoundException(ErrorMessages.KUDI_USER_CREATION_FAILED)));
        AppUserDomainObject savedUser = userPersistenceOutputPort.saveUser(domainObject);
        AppAccountDomainObject appAccount = new AppAccountDomainObject();
        appAccount.setAccountBalance(BigDecimal.valueOf(0.0));
        appAccount.setAccountNumber(generateAccountNumber());
        appAccount.setAccountType(AccountType.valueOf(domainObject.getAppAccount().getAccountType().toString().toUpperCase()));
        appAccount.setAppUser(savedUser);
        appAccountPersistenceOutputPort.saveAccount(appAccount);
        return savedUser;
    }

    public void validateFields(AppUserDomainObject domainObject){
        validateName(domainObject.getUsername());
        validateEmail(domainObject.getEmail());
        validatePassword(domainObject.getPassword());
        validatePhoneNumber(domainObject.getPhoneNumber());
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
        Optional <AppUserEntity> foundUser = appUserRepository.findAppUsersByEmail(signInRequest.getEmail());
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
    public CancelTransactionResponse cancelTransaction(CancelTransactionRequest cancelTransactionRequest) {
        return null;
    }

    @Override
    public ViewUserDetailsResponse viewUserProfile(ViewUserDetailsRequest viewUserDetailsRequest) {
        return null;
    }

    @Override
    public ViewAccountDetailsResponse viewAccountProfile(ViewAccountDetailsRequest viewAccountDetailsRequest) {
        return null;
    }


}
