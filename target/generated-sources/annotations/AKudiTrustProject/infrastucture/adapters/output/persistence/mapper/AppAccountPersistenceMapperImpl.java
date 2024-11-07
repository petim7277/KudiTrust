package AKudiTrustProject.infrastucture.adapters.output.persistence.mapper;

import AKudiTrustProject.domain.models.AppAccountDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppAccountEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T16:36:42+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AppAccountPersistenceMapperImpl implements AppAccountPersistenceMapper {

    @Override
    public AppAccountEntity toAppAccountEntity(AppAccountDomainObject appAccountDomainObject) {
        if ( appAccountDomainObject == null ) {
            return null;
        }

        AppAccountEntity appAccountEntity = new AppAccountEntity();

        appAccountEntity.setAccountId( appAccountDomainObject.getAccountId() );
        appAccountEntity.setAccountNumber( appAccountDomainObject.getAccountNumber() );
        appAccountEntity.setAccountBalance( appAccountDomainObject.getAccountBalance() );
        appAccountEntity.setAccountType( appAccountDomainObject.getAccountType() );
        appAccountEntity.setCreatedAt( appAccountDomainObject.getCreatedAt() );
        appAccountEntity.setUpdatedAt( appAccountDomainObject.getUpdatedAt() );

        return appAccountEntity;
    }

    @Override
    public AppAccountDomainObject toAppAccount(AppAccountEntity appAccountEntity) {
        if ( appAccountEntity == null ) {
            return null;
        }

        AppAccountDomainObject appAccountDomainObject = new AppAccountDomainObject();

        appAccountDomainObject.setAccountId( appAccountEntity.getAccountId() );
        appAccountDomainObject.setAccountNumber( appAccountEntity.getAccountNumber() );
        appAccountDomainObject.setAccountBalance( appAccountEntity.getAccountBalance() );
        appAccountDomainObject.setAccountType( appAccountEntity.getAccountType() );
        appAccountDomainObject.setCreatedAt( appAccountEntity.getCreatedAt() );
        appAccountDomainObject.setUpdatedAt( appAccountEntity.getUpdatedAt() );

        return appAccountDomainObject;
    }
}
