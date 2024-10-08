package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppUserDomainObject;

import java.util.Optional;

public interface AppUserPersistenceOutputPort {
    AppUserDomainObject saveUser(String username);
    Optional<AppUserDomainObject> findById(Long userId);

}
