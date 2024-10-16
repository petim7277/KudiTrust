package AKudiTrustProject.infrastucture.adapters.output.persistence.repositories;

import AKudiTrustProject.domain.models.AppTransactionDomainObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<AppTransactionDomainObject,Long> {
}
