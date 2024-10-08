package AKudiTrustProject.data.repositories;

import AKudiTrustProject.domain.models.AppAccountDomainObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppAccountRepository extends JpaRepository<AppAccountDomainObject,Long> {
}
