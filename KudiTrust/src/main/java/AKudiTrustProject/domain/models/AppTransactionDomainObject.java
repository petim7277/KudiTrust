package AKudiTrustProject.domain.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AppTransactionDomainObject {
    @Id
 private Long transactionId;
 private LocalDateTime transactionDate;
 private String description;

}
