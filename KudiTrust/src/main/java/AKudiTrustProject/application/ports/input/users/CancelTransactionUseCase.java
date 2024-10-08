package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.CancelTransactionRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.CancelTransactionResponse;

public interface CancelTransactionUseCase {
    CancelTransactionResponse cancelTransaction (CancelTransactionRequest cancelTransactionRequest);

}
