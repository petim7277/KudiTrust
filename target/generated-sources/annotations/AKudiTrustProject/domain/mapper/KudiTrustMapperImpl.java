package AKudiTrustProject.domain.mapper;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import javax.annotation.processing.Generated;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-05T19:35:48+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class KudiTrustMapperImpl implements KudiTrustMapper {

    @Override
    public AppUserDomainObject toSignUpRequest(SignUpRequest signUpRequest) {
        if ( signUpRequest == null ) {
            return null;
        }

        AppUserDomainObject appUserDomainObject = new AppUserDomainObject();

        appUserDomainObject.setFirstname( signUpRequest.getFirstname() );
        appUserDomainObject.setLastname( signUpRequest.getLastname() );
        appUserDomainObject.setUsername( signUpRequest.getUsername() );
        appUserDomainObject.setPassword( signUpRequest.getPassword() );
        appUserDomainObject.setEmail( signUpRequest.getEmail() );
        appUserDomainObject.setPhoneNumber( signUpRequest.getPhoneNumber() );

        return appUserDomainObject;
    }

    @Override
    public UserRepresentation toUserRepresentation(SignUpRequest signUpRequest) {
        if ( signUpRequest == null ) {
            return null;
        }

        UserRepresentation userRepresentation = new UserRepresentation();

        userRepresentation.setEmail( signUpRequest.getEmail() );
        userRepresentation.setUsername( signUpRequest.getUsername() );

        return userRepresentation;
    }

    @Override
    public SignUpRequest toSignUpRequest(UserRepresentation userRepresentation) {
        if ( userRepresentation == null ) {
            return null;
        }

        SignUpRequest signUpRequest = new SignUpRequest();

        signUpRequest.setUsername( userRepresentation.getUsername() );
        signUpRequest.setEmail( userRepresentation.getEmail() );

        return signUpRequest;
    }
}
