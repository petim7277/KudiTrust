package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppAccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppAccountPersistenceMapper {
    AppAccountEntity toAppAccountEntity(AppAccountDomainObject appAccountDomainObject);
    AppAccountDomainObject toAppAccount(AppAccountEntity appAccountEntity);
}
