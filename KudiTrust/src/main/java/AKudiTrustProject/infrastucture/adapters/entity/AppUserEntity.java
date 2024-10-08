package AKudiTrustProject.infrastucture.adapters.entity;

import AKudiTrustProject.domain.models.AppAccountDomainObject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Setter
@Getter
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private AppAccountDomainObject appAccount;
}
