package AKudiTrustProject.application.ports.input.transactions;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.InitializeTransactionRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.InitializeTransactionResponse;

public interface StartTransactionUseCase {
    InitializeTransactionResponse startTransaction(InitializeTransactionRequest initializeTransactionRequest);

}
