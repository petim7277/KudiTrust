package AKudiTrustProject.application.ports.input.transactions;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.CancelTransactionRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.CancelTransactionResponse;

public interface TerminateTransactionUseCase {
    CancelTransactionResponse terminateTransaction(CancelTransactionRequest cancelTransactionRequest);

}
