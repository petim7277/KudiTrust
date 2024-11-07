package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AppUserPersistenceMapper {
    AppUserEntity toAppUserEntity(AppUser appUserDomainObject);
    AppUser toAppUser(AppUserEntity appUserEntity);
    UserRepresentation toUserRepresentation(AppUser userDomainObject);
    @Mapping(target = "id", ignore = true)
    AppUser toAppDomainObject(UserRepresentation userRepresentation);
    AppUser toOptionalAppUserDomainObject(Optional<AppUser> appUserDomainObject);
}
