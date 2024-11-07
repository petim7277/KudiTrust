package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppUser;

public interface AppUserPersistenceOutputPort {
    AppUser saveUser(AppUser appUser);
    AppUser findUserById(Long userId);
    AppUser findUserByEmail(String email);
    void deleteEntity(AppUser appUserDomainObject);
}
