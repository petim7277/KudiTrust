package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.ViewUserDetailsRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.ViewUserDetailsResponse;

public interface ViewUserProfileUseCase {
    ViewUserDetailsResponse viewUserProfile (ViewUserDetailsRequest viewUserDetailsRequest);

}
