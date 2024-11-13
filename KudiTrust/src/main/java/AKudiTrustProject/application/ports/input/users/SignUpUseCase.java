package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.domain.models.AppUser;

public interface SignUpUseCase {
    AppUser signUp(AppUser domainObject);

}
