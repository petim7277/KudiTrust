package AKudiTrustProject.dtos.requests;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewAccountDetailsRequest {
    private String username;
    private String password;
}