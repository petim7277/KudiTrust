package AKudiTrustProject.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class AppNotification {
    @Id
   private Long notificationId ;
   private Long userId;
   private String title;
   private String messageBody;
   private NotificationDeliveryMode notificationDeliveryMode;
   private Date createdAt;
   private Date sentAt;
}
