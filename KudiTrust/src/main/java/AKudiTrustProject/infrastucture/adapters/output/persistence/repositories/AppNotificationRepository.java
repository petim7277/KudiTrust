package AKudiTrustProject.infrastucture.adapters.output.persistence.repositories;

import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppNotificationRepository extends JpaRepository<AppNotificationEntity,Long> {
}
