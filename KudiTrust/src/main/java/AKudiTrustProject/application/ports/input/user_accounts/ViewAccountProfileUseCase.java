package AKudiTrustProject.application.ports.input.user_accounts;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.ViewAccountDetailsRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.ViewAccountDetailsResponse;

public interface ViewAccountProfileUseCase {
    ViewAccountDetailsResponse viewAccountProfile(ViewAccountDetailsRequest viewAccountDetailsRequest);

}
