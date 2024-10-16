package AKudiTrustProject.domain.models;
import AKudiTrustProject.domain.models.enums.NotificationDeliveryMode;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppNotificationDomainObject {
    @Id
   private Long notificationId ;
   private Long userId;
   private String title;
   private String messageBody;
   private NotificationDeliveryMode notificationDeliveryMode;
   private Date createdAt;
   private Date sentAt;

}
