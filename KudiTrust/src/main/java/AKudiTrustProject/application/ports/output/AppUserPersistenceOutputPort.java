package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;

import java.util.Optional;

public interface AppUserPersistenceOutputPort {
    AppUserDomainObject saveUser(AppUserDomainObject appUser);
    AppUserDomainObject findUserById(Long userId);
    Optional<AppUserDomainObject> findUserByEmail(String email);

}
