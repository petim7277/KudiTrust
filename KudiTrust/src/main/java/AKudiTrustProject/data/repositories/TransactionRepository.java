package AKudiTrustProject.data.repositories;

import AKudiTrustProject.data.models.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<AppTransaction,Long> {
}
