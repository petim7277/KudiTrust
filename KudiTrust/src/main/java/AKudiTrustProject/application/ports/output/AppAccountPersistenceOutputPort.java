package AKudiTrustProject.application.ports.output;

import AKudiTrustProject.domain.models.AppAccountDomainObject;

import java.util.Optional;

public interface AppAccountPersistenceOutputPort {
    AppAccountDomainObject saveAccount(AppAccountDomainObject appAccount);
    Optional<AppAccountDomainObject> findAccountById(Long appAccountId);
}
