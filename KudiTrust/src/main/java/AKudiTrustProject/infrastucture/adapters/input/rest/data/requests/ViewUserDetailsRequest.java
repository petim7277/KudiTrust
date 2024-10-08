package AKudiTrustProject.infrastucture.adapters.input.rest.data.requests;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ViewUserDetailsRequest {
    private String username;
    private String password;
}
