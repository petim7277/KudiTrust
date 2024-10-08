package AKudiTrustProject.infrastucture.adapters.entity;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.domain.models.enums.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class AppAccountEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private  Long accountId;
    private  String accountNumber;
    private BigDecimal accountBalance;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private LocalDateTime createdAt = LocalDateTime.now() ;
    private LocalDate updatedAt = LocalDate.now();
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
    private AppUserDomainObject appUser;














}
