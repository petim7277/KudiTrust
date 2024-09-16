package AKudiTrustProject.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
public class AppUser {
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
    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL)
    private AppAccount appAccount;

}
