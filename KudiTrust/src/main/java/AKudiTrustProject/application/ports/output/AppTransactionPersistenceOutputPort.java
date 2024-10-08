package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppTransaction;

import java.util.Optional;

public interface AppTransactionPersistenceOutputPort {
    AppTransaction saveTransaction(AppTransaction transaction);
    Optional<AppTransaction> findTransactionById(Long transactionId);
}
