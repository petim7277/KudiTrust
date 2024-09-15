package AKudiTrustProject.data.repositories;

import AKudiTrustProject.data.models.AppAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppAccountRepository extends JpaRepository<AppAccount,Long> {
}
