package AKudiTrustProject.domain.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AppTransaction {
    @Id
 private Long transactionId;
 private LocalDateTime transactionDate;
 private String description;

}
