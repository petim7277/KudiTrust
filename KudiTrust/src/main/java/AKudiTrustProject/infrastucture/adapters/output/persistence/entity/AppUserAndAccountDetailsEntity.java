package AKudiTrustProject.infrastucture.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AppUserAndAccountDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private AppUserEntity appUser;
    @OneToOne
    private AppAccountEntity appAccount;

}
