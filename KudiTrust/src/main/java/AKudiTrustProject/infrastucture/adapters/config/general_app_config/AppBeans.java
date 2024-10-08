package AKudiTrustProject.infrastucture.adapters.config.general_app_config;

import AKudiTrustProject.data.repositories.AppAccountRepository;
import AKudiTrustProject.data.repositories.AppUserRepository;
import AKudiTrustProject.domain.mapper.KudiTrustMapper;
import AKudiTrustProject.domain.services.AppUserService;
//import AKudiTrustProject.keycloak.KudiUserIdentityAdapter;
//import org.keycloak.admin.client.Keycloak;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeans {
    @Bean
    AppUserService appUserService(AppUserRepository appUserRepository, AppAccountRepository appAccountRepository,
                                   KudiTrustMapper kudiTrustMapper) {
        return new AppUserService(appUserRepository, appAccountRepository, kudiTrustMapper);
    }

//    @Bean
//    KudiUserIdentityAdapter kudiUserIdentityAdapter(Keycloak keycloak,KudiTrustMapper kudiTrustMapper) {
//        return new KudiUserIdentityAdapter(keycloak,kudiTrustMapper);
//    }

}
