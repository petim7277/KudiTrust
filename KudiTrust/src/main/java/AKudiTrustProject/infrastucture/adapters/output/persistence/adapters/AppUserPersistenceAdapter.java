package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters;

import AKudiTrustProject.application.ports.output.AppUserPersistenceOutputPort;
import AKudiTrustProject.domain.exceptions.ErrorMessages;
import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.exception.IdentityManagerException;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppUserPersistenceAdapter  implements AppUserPersistenceOutputPort {
    private  final AppUserRepository appUserRepository;
    private final AppUserPersistenceMapper appUserPersistenceMapper;

    @Override
    public AppUser saveUser(AppUser domainObject) {
      AppUserEntity savedEntity = appUserPersistenceMapper.toAppUserEntity(domainObject);
      appUserRepository.save(savedEntity);
      return appUserPersistenceMapper.toAppUser(savedEntity);
    }

    @Override
    public AppUser findUserById(Long userId) {
        if (StringUtils.isNotBlank(String.valueOf(userId)) || StringUtils.isEmpty(String.valueOf(userId))) {
            AppUserEntity foundEntity = appUserRepository.findById(userId)
                    .orElseThrow(()-> new  IdentityManagerException(ErrorMessages.KUDI_USER_NOT_FOUND, HttpStatus.NOT_FOUND));
            return appUserPersistenceMapper.toAppUser(foundEntity);
        }
        throw new IdentityManagerException(ErrorMessages.KUDI_USER_IDENTITY_CANT_BE_EMPTY, HttpStatus.BAD_REQUEST);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        if (StringUtils.isNotBlank(email) || StringUtils.isEmpty(email)) {
            AppUserEntity foundEntity = appUserRepository.findAppUsersByEmail(email);
            return appUserPersistenceMapper.toAppUser(foundEntity);
        }
        throw new IdentityManagerException(ErrorMessages.KUDI_USER_EMAIL_CANT_BE_EMPTY, HttpStatus.BAD_REQUEST);
    }
    @Override
    public void deleteEntity(AppUser appUserDomainObject) {
        AppUserEntity mappedEntity = appUserPersistenceMapper.toAppUserEntity(appUserDomainObject);
        appUserRepository.delete(mappedEntity);
    }
}
