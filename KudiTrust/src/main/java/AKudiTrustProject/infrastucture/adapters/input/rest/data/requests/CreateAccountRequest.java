package AKudiTrustProject.infrastucture.adapters.input.rest.data.requests;
import AKudiTrustProject.domain.models.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateAccountRequest {
    private AccountType accountType;
}
