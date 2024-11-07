package AKudiTrustProject.domain.services;
import AKudiTrustProject.application.ports.input.user_accounts.ViewAccountProfileUseCase;
import AKudiTrustProject.application.ports.input.users.*;
import AKudiTrustProject.application.ports.output.AppAccountPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.AppUserPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.AppUserAndAccountsDetailsPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserNotFoundException;
import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.domain.models.AppUserAndAccountDetailsDomainObject;
import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppAccountPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.domain.kudi_user_exceptions.KudiUserAlreadyExistException;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.*;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;

import static AKudiTrustProject.domain.validator.KudiTrustValidator.*;

@Slf4j
@AllArgsConstructor
@Service
public class AppUserService implements SignUpUseCase, SignInUseCase, TransferMoneyUsecase, RecieveMoneyUseCase,
                                        CancelTransactionUseCase,ViewUserProfileUseCase,ViewAccountProfileUseCase{
    private  final AppUserRepository appUserRepository;
    private final AppUserPersistenceOutputPort userPersistenceOutputPort;
    private final AppAccountPersistenceOutputPort appAccountPersistenceOutputPort;
    private final KudiUserIdentityManagerOutPutPort kudiUserIdentityManagerOutPutPort;
    private final AppUserAndAccountsDetailsPersistenceOutputPort userAndAccountsDetailsPersistenceOutputPort;
    private final AppUserPersistenceMapper appUserPersistenceMapper;
    private final AppAccountPersistenceMapper appAccountPersistenceMapper;

    @Override
    public AppUser signUp(AppUser domainObject) {
        validateFields(domainObject);
        AppUser foundUser = userPersistenceOutputPort.findUserByEmail(domainObject.getEmail());
        if (foundUser != null) {throw  new KudiUserAlreadyExistException(ErrorMessages.KUDI_USER_ALREADY_EXIST,HttpStatus.BAD_REQUEST);}
            else {
                AppUser createdUser = userPersistenceOutputPort.saveUser(domainObject);

                AppAccountDomainObject appAccount = new AppAccountDomainObject();
                appAccount.setAccountBalance(BigDecimal.valueOf(0.0));
                appAccount.setAccountNumber(generateAccountNumber());
                appAccount.setAccountType(createdUser.getAccountType());
                AppAccountDomainObject savedAccount  = appAccountPersistenceOutputPort.saveAccount(appAccount);

                AppUserAndAccountDetailsDomainObject detailsDomainObject = new AppUserAndAccountDetailsDomainObject();
                detailsDomainObject.setAppAccount(appAccountPersistenceMapper.toAppAccountEntity(savedAccount));
                detailsDomainObject.setAppUser(appUserPersistenceMapper.toAppUserEntity(createdUser));
                userAndAccountsDetailsPersistenceOutputPort.saveDetails(detailsDomainObject);

                AppUser createdKeycloakUser = kudiUserIdentityManagerOutPutPort.createUser(createdUser);
                if (createdKeycloakUser == null) {
                    throw new KudiTrustExceptions(ErrorMessages.KUDI_USER_CREATION_FAILED,HttpStatus.BAD_REQUEST);
                }
                return createdUser;
            }

    }



    public void validateFields(AppUser domainObject){
        validateName(domainObject.getUsername());
        validateEmail(domainObject.getEmail());
        validatePassword(domainObject.getPassword());
        validatePhoneNumber(domainObject.getPhoneNumber());
    }

    public static String generateAccountNumber( ) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder randomNumber = new StringBuilder(10);
        for (int count = 0; count < 10; count++) {
            int digit = secureRandom.nextInt(10);
            randomNumber.append(digit);
        }
        return randomNumber.toString();
    }

    @Override
    public AppUser signIn(AppUser userDomainObject) {
        AppUserEntity foundUser = appUserRepository.findAppUsersByEmail(userDomainObject.getEmail());
        if (foundUser== null){throw  new KudiUserNotFoundException(ErrorMessages.KUDI_USER_NOT_FOUND,HttpStatus.NOT_FOUND);}
        return appUserPersistenceMapper.toAppUser(foundUser);
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
