package AKudiTrustProject.infrastucture.adapters.config.general_app_config;

import AKudiTrustProject.application.ports.output.AppAccountPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.AppUserAndAccountsDetailsPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.AppUserPersistenceOutputPort;
import AKudiTrustProject.application.ports.output.keycloak.KudiUserIdentityManagerOutPutPort;
import AKudiTrustProject.domain.services.AppTransactionService;
import AKudiTrustProject.infrastucture.adapters.config.paystack_config.PaystackConfig;
import AKudiTrustProject.infrastucture.adapters.output.persistence.adapters.keycloak.KeycloakAdapter;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppAccountPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.mapper.AppUserPersistenceMapper;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import AKudiTrustProject.domain.services.AppUserService;
import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeans {
    @Bean
    AppUserService appUserService(AppUserRepository appUserRepository, AppUserPersistenceOutputPort appUserPersistenceOutputPort,
                                  AppAccountPersistenceOutputPort appAccountPersistenceOutputPort, KudiUserIdentityManagerOutPutPort kudiUserIdentityManagerOutPutPort,
                                    AppUserAndAccountsDetailsPersistenceOutputPort userAndAccountsDetailsPersistenceOutputPort,AppUserPersistenceMapper appUserPersistenceMapper,
                                  AppAccountPersistenceMapper appAccountPersistenceMapper) {
        return new AppUserService(appUserRepository,appUserPersistenceOutputPort,appAccountPersistenceOutputPort,kudiUserIdentityManagerOutPutPort,userAndAccountsDetailsPersistenceOutputPort,
                                   appUserPersistenceMapper,appAccountPersistenceMapper);
    }

    @Bean
    KeycloakAdapter kudiUserIdentityAdapter(Keycloak keycloak, AppUserPersistenceMapper appUserPersistenceMapper,AppUserPersistenceOutputPort appUserPersistenceOutputPort) {
        return new KeycloakAdapter(keycloak,appUserPersistenceMapper,appUserPersistenceOutputPort);
    }

    @Bean
    AppTransactionService appTransactionService(PaystackConfig paystackConfig,AppUserRepository appUserRepository){
        return new AppTransactionService(paystackConfig, appUserRepository);
    }



}
