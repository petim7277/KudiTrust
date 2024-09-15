package AKudiTrustProject.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class AppAccount {
    @Id
    private  Long accountId;
    private  Long accountNumber;
    private  BigDecimal accountBalance;
    private  Long userId;
    private  AccountType accountType;
    private  Date createdAt;
    private  Date updatedAt;
}
