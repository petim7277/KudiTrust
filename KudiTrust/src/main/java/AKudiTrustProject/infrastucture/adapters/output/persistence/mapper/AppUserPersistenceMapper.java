package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserPersistenceMapper {
    AppUserEntity toAppUserEntity(AppUserDomainObject appUserDomainObject);
    AppUserDomainObject toAppUser(AppUserEntity appUserEntity);
    UserRepresentation toUserRepresentation(AppUserDomainObject userDomainObject);
    AppUserDomainObject toAppDomainObject(UserRepresentation userRepresentation);
}
