package AKudiTrustProject.data.repositories;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserDomainObject,Long> {
    Optional<AppUserDomainObject> findAppUsersByUsername(String username);
    Optional<AppUserDomainObject> findAppUsersByEmail(String email);
}
