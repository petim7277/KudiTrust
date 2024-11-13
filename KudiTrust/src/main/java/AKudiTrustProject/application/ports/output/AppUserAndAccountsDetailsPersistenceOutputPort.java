package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppUserAndAccountDetailsDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserAndAccountDetailsEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public interface AppUserAndAccountsDetailsPersistenceOutputPort {

    AppUserAndAccountDetailsEntity saveDetails(AppUserAndAccountDetailsDomainObject domainObject);

}
