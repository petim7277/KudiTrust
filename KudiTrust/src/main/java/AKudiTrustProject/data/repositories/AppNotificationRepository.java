package AKudiTrustProject.data.repositories;

import AKudiTrustProject.domain.models.AppNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppNotificationRepository extends JpaRepository<AppNotification,Long> {
}
