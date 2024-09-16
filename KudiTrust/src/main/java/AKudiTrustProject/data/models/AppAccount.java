package AKudiTrustProject.data.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class AppAccount {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private  Long accountId;
    private  String accountNumber;
    private  BigDecimal accountBalance;
    @Enumerated(EnumType.STRING)
    private  AccountType accountType;
    private LocalDateTime createdAt = LocalDateTime.now() ;
    private  LocalDate updatedAt = LocalDate.now();
    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
}
