package AKudiTrustProject.domain.mapper;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SignUpRequest;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import javax.annotation.processing.Generated;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T10:12:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class KudiTrustMapperImpl implements KudiTrustMapper {

    @Override
    public AppUserEntity toSignUpRequest(SignUpRequest signUpRequest) {
        if ( signUpRequest == null ) {
            return null;
        }

        AppUserEntity appUserEntity = new AppUserEntity();

        appUserEntity.setFirstname( signUpRequest.getFirstname() );
        appUserEntity.setLastname( signUpRequest.getLastname() );
        appUserEntity.setUsername( signUpRequest.getUsername() );
        appUserEntity.setPassword( signUpRequest.getPassword() );
        appUserEntity.setEmail( signUpRequest.getEmail() );
        appUserEntity.setPhoneNumber( signUpRequest.getPhoneNumber() );

        return appUserEntity;
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
