package AKudiTrustProject.infrastucture.adapters.input.rest.data.requests;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InitializeTransactionRequest {
    private String amount;
    private String email;

}
