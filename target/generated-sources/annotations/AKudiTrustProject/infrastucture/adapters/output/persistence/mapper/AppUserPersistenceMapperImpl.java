package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUser;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T16:36:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AppUserPersistenceMapperImpl implements AppUserPersistenceMapper {

    @Override
    public AppUserEntity toAppUserEntity(AppUser appUserDomainObject) {
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
        appUserEntity.setAccountType( appUserDomainObject.getAccountType() );

        return appUserEntity;
    }

    @Override
    public AppUser toAppUser(AppUserEntity appUserEntity) {
        if ( appUserEntity == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( appUserEntity.getId() );
        appUser.setFirstname( appUserEntity.getFirstname() );
        appUser.setLastname( appUserEntity.getLastname() );
        appUser.setUsername( appUserEntity.getUsername() );
        appUser.setPassword( appUserEntity.getPassword() );
        appUser.setEmail( appUserEntity.getEmail() );
        appUser.setPhoneNumber( appUserEntity.getPhoneNumber() );
        appUser.setCreatedAt( appUserEntity.getCreatedAt() );
        appUser.setAccountType( appUserEntity.getAccountType() );

        return appUser;
    }

    @Override
    public UserRepresentation toUserRepresentation(AppUser userDomainObject) {
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
    public AppUser toAppDomainObject(UserRepresentation userRepresentation) {
        if ( userRepresentation == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setUsername( userRepresentation.getUsername() );
        appUser.setEmail( userRepresentation.getEmail() );

        return appUser;
    }

    @Override
    public AppUser toOptionalAppUserDomainObject(Optional<AppUser> appUserDomainObject) {
        if ( appUserDomainObject == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        return appUser;
    }
}
