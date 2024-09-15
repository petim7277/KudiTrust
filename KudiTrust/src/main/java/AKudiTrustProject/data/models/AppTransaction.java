package AKudiTrustProject.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class AppTransaction {
    @Id
 private Long transactionId;
 private Date transactionDate;
}
