package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppUserAndAccountDetailsDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserAndAccountDetailsEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T11:52:31+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AppUserAndAccountsDetailsMapperImpl implements AppUserAndAccountsDetailsMapper {

    @Override
    public AppUserAndAccountDetailsEntity toObject(AppUserAndAccountDetailsDomainObject domainObject) {
        if ( domainObject == null ) {
            return null;
        }

        AppUserAndAccountDetailsEntity appUserAndAccountDetailsEntity = new AppUserAndAccountDetailsEntity();

        appUserAndAccountDetailsEntity.setId( domainObject.getId() );
        appUserAndAccountDetailsEntity.setAppUser( domainObject.getAppUser() );
        appUserAndAccountDetailsEntity.setAppAccount( domainObject.getAppAccount() );

        return appUserAndAccountDetailsEntity;
    }
}
