package AKudiTrustProject.data.repositories;

import AKudiTrustProject.data.models.AppNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppNotificationRepository extends JpaRepository<AppNotification,Long> {
}