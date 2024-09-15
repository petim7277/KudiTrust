package AKudiTrustProject.services;
import AKudiTrustProject.dtos.requests.CancelTransactionRequest;
import AKudiTrustProject.dtos.requests.InitializeTransactionRequest;
import AKudiTrustProject.dtos.requests.ViewTransactionHistoryRequest;
import AKudiTrustProject.dtos.responses.CancelTransactionResponse;
import AKudiTrustProject.dtos.responses.InitializeTransactionResponse;
import AKudiTrustProject.dtos.responses.ViewTransactionHistoryResponse;

import java.math.BigDecimal;

public interface AppTransactionService {
    InitializeTransactionResponse startTransaction(InitializeTransactionRequest initializeTransactionRequest);
    BigDecimal getAccountBalance (BigDecimal balance);
    ViewTransactionHistoryResponse getTransactionHistory (ViewTransactionHistoryRequest transactionHistoryRequest);
    CancelTransactionResponse terminateTransaction(CancelTransactionRequest cancelTransactionRequest);
}
