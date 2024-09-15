package AKudiTrustProject.data.repositories;

import AKudiTrustProject.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findAppUsersByUsername(String username);
    Optional<AppUser> findAppUsersByEmail(String email);
}
