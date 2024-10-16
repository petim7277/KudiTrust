package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppTransactionDomainObject;

import java.util.Optional;

public interface AppTransactionPersistenceOutputPort {
    AppTransactionDomainObject saveTransaction(AppTransactionDomainObject transaction);
    Optional<AppTransactionDomainObject> findTransactionById(Long transactionId);
}
