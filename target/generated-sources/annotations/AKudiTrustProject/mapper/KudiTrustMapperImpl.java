package AKudiTrustProject.mapper;

import AKudiTrustProject.data.models.AppUser;
import AKudiTrustProject.dtos.requests.SignUpRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T12:49:20+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class KudiTrustMapperImpl implements KudiTrustMapper {

    @Override
    public AppUser toSignUpRequest(SignUpRequest signUpRequest) {
        if ( signUpRequest == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setFirstname( signUpRequest.getFirstname() );
        appUser.setLastname( signUpRequest.getLastname() );
        appUser.setUsername( signUpRequest.getUsername() );
        appUser.setPassword( signUpRequest.getPassword() );
        appUser.setEmail( signUpRequest.getEmail() );
        appUser.setPhoneNumber( signUpRequest.getPhoneNumber() );

        return appUser;
    }
}
