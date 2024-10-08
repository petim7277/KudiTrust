package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.RecieveMoneyRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.RecieveMoneyResponse;

public interface RecieveMoneyUseCase {
    RecieveMoneyResponse recieveMoney(RecieveMoneyRequest recieveMoneyRequest);

}
