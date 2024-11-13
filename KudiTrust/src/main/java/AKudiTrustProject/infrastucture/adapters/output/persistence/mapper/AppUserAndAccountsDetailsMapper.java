package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUserAndAccountDetailsDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserAndAccountDetailsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserAndAccountsDetailsMapper {
    AppUserAndAccountDetailsEntity toObject (AppUserAndAccountDetailsDomainObject domainObject);

}
