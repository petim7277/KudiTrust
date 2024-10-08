package AKudiTrustProject.application.ports.input.transactions;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.ViewTransactionHistoryRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.ViewTransactionHistoryResponse;

public interface ViewTransactionHistoryUseCase {
    ViewTransactionHistoryResponse viewTransactionHistory (ViewTransactionHistoryRequest transactionHistoryRequest);

}
