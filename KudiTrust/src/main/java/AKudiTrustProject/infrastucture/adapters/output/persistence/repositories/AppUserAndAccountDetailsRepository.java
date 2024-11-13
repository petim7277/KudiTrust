package AKudiTrustProject.infrastucture.adapters.output.persistence.repositories;

import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserAndAccountDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserAndAccountDetailsRepository extends JpaRepository<AppUserAndAccountDetailsEntity, Long> {
}
