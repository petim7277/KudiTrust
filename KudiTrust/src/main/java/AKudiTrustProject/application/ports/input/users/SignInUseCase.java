package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.domain.models.AppUser;

public interface SignInUseCase {
    AppUser signIn(AppUser userDomainObject);

}
