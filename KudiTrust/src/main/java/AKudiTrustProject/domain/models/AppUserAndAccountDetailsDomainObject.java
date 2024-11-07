package AKudiTrustProject.domain.models;

import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppAccountEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AppUserAndAccountDetailsDomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private AppUserEntity appUser;
    @OneToOne
    private AppAccountEntity appAccount;

}
