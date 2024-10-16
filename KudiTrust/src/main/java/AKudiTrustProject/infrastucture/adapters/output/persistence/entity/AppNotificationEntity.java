package AKudiTrustProject.infrastucture.adapters.output.persistence.entity;

import AKudiTrustProject.domain.models.enums.NotificationDeliveryMode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Setter
@Getter
public class AppNotificationEntity {

    @Id
    private Long notificationId ;
    private Long userId;
    private String title;
    private String messageBody;
    private NotificationDeliveryMode notificationDeliveryMode;
    private Date createdAt;
    private Date sentAt;

}
