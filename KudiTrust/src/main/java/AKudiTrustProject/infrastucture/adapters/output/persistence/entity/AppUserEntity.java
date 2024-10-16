package AKudiTrustProject.infrastucture.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Setter
@Getter
@NamedQuery(name = "AppUser.findByPassword", query = "SELECT password FROM AppUserEntity userEntity WHERE userEntity.password = :password")
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
//    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
//    private AppAccountDomainObject appAccount;
}
