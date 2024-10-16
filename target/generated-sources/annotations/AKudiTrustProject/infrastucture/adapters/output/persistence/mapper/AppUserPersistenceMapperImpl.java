package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUserDomainObject;
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
public class AppUserPersistenceMapperImpl implements AppUserPersistenceMapper {

    @Override
    public AppUserEntity toAppUserEntity(AppUserDomainObject appUserDomainObject) {
        if ( appUserDomainObject == null ) {
            return null;
        }

        AppUserEntity appUserEntity = new AppUserEntity();

        appUserEntity.setId( appUserDomainObject.getId() );
        appUserEntity.setFirstname( appUserDomainObject.getFirstname() );
        appUserEntity.setLastname( appUserDomainObject.getLastname() );
        appUserEntity.setUsername( appUserDomainObject.getUsername() );
        appUserEntity.setPassword( appUserDomainObject.getPassword() );
        appUserEntity.setEmail( appUserDomainObject.getEmail() );
        appUserEntity.setPhoneNumber( appUserDomainObject.getPhoneNumber() );
        appUserEntity.setCreatedAt( appUserDomainObject.getCreatedAt() );

        return appUserEntity;
    }

    @Override
    public AppUserDomainObject toAppUser(AppUserEntity appUserEntity) {
        if ( appUserEntity == null ) {
            return null;
        }

        AppUserDomainObject appUserDomainObject = new AppUserDomainObject();

        appUserDomainObject.setId( appUserEntity.getId() );
        appUserDomainObject.setFirstname( appUserEntity.getFirstname() );
        appUserDomainObject.setLastname( appUserEntity.getLastname() );
        appUserDomainObject.setUsername( appUserEntity.getUsername() );
        appUserDomainObject.setPassword( appUserEntity.getPassword() );
        appUserDomainObject.setEmail( appUserEntity.getEmail() );
        appUserDomainObject.setPhoneNumber( appUserEntity.getPhoneNumber() );
        appUserDomainObject.setCreatedAt( appUserEntity.getCreatedAt() );

        return appUserDomainObject;
    }

    @Override
    public UserRepresentation toUserRepresentation(AppUserDomainObject userDomainObject) {
        if ( userDomainObject == null ) {
            return null;
        }

        UserRepresentation userRepresentation = new UserRepresentation();

        if ( userDomainObject.getId() != null ) {
            userRepresentation.setId( String.valueOf( userDomainObject.getId() ) );
        }
        userRepresentation.setEmail( userDomainObject.getEmail() );
        userRepresentation.setUsername( userDomainObject.getUsername() );

        return userRepresentation;
    }

    @Override
    public AppUserDomainObject toAppDomainObject(UserRepresentation userRepresentation) {
        if ( userRepresentation == null ) {
            return null;
        }

        AppUserDomainObject appUserDomainObject = new AppUserDomainObject();

        if ( userRepresentation.getId() != null ) {
            appUserDomainObject.setId( Long.parseLong( userRepresentation.getId() ) );
        }
        appUserDomainObject.setUsername( userRepresentation.getUsername() );
        appUserDomainObject.setEmail( userRepresentation.getEmail() );

        return appUserDomainObject;
    }
}
