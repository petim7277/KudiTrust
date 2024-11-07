package AKudiTrustProject.infrastucture.adapters.config.security_config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
 @Bean
 public DefaultSecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
     return httpSecurity
             .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
             .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                     .requestMatchers("/").permitAll()
                     .requestMatchers("/api/v1/AppUserController/KudiSignUp")
                     .authenticated()
             )
             .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
             .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                     .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .build();
 }
}
