package AKudiTrustProject.infrastucture.adapters.output.persistence.adapters;

import AKudiTrustProject.application.ports.output.AppUserAndAccountsDetailsPersistenceOutputPort;
import AKudiTrustProject.domain.models.AppUserAndAccountDetailsDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserAndAccountDetailsEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserAndAccountsDetailsMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserAndAccountDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppUserAndAccountDetailsPersistenceAdapter implements AppUserAndAccountsDetailsPersistenceOutputPort {

  private final AppUserAndAccountDetailsRepository appUserAndAccountDetailsRepository;
  private final AppUserAndAccountsDetailsMapper appUserAndAccountsDetailsMapper;

    @Override
    public AppUserAndAccountDetailsEntity saveDetails(AppUserAndAccountDetailsDomainObject domainObject) {
     AppUserAndAccountDetailsEntity savedEntity = appUserAndAccountsDetailsMapper.toObject(domainObject);
     appUserAndAccountDetailsRepository.save(savedEntity);
     return savedEntity;
    }
}
