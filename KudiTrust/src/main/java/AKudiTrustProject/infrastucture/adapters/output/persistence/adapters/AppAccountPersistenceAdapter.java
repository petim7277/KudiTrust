package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters;

import AKudiTrustProject.application.ports.output.AppAccountPersistenceOutputPort;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.exception.IdentityManagerException;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppAccountEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppAccountPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppAccountRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class AppAccountPersistenceAdapter implements AppAccountPersistenceOutputPort {

    private final AppAccountPersistenceMapper appAccountPersistenceMapper;
    private final AppAccountRepository appAccountRepository;

    @Override
    public AppAccountDomainObject saveAccount(AppAccountDomainObject appAccount) {
        AppAccountEntity savedEntity = appAccountPersistenceMapper.toAppAccountEntity(appAccount);
        appAccountRepository.save(savedEntity);
        return appAccountPersistenceMapper.toAppAccount(savedEntity);
    }

    @Override
    public Optional<AppAccountDomainObject> findAccountById(Long accountId) {
        if (StringUtils.isNotBlank(String.valueOf(accountId)) || StringUtils.isEmpty(String.valueOf(accountId))) {
            AppAccountEntity foundEntity = appAccountRepository.findById(accountId)
                    .orElseThrow(()-> new IdentityManagerException(ErrorMessages.KUDI_USER_NOT_FOUND, HttpStatus.NOT_FOUND));
            return Optional.ofNullable(appAccountPersistenceMapper.toAppAccount(foundEntity));
        }
        throw new IdentityManagerException(ErrorMessages.KUDI_USER_IDENTITY_CANT_BE_EMPTY, HttpStatus.BAD_REQUEST);
    }
}
