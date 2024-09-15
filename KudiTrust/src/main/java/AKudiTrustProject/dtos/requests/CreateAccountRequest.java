package AKudiTrustProject.dtos.requests;
import AKudiTrustProject.data.models.AccountType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateAccountRequest {
    private AccountType accountType;
}
