package AKudiTrustProject.infrastucture.adapters.output.persistence.repositories;

import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppAccountRepository extends JpaRepository<AppAccountEntity,Long> {
}
