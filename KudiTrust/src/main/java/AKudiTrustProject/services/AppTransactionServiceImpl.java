package AKudiTrustProject.services;

import AKudiTrustProject.dtos.requests.CancelTransactionRequest;
import AKudiTrustProject.dtos.requests.InitializeTransactionRequest;
import AKudiTrustProject.dtos.requests.ViewTransactionHistoryRequest;
import AKudiTrustProject.dtos.responses.CancelTransactionResponse;
import AKudiTrustProject.dtos.responses.InitializeTransactionResponse;
import AKudiTrustProject.dtos.responses.ViewTransactionHistoryResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class AppTransactionServiceImpl implements AppTransactionService{
    @Override
    public InitializeTransactionResponse startTransaction(InitializeTransactionRequest initializeTransactionRequest) {
        return null;
    }

    @Override
    public BigDecimal getAccountBalance(BigDecimal balance) {
        return null;
    }

    @Override
    public ViewTransactionHistoryResponse getTransactionHistory(ViewTransactionHistoryRequest transactionHistoryRequest) {
        return null;
    }

    @Override
    public CancelTransactionResponse terminateTransaction(CancelTransactionRequest cancelTransactionRequest) {
        return null;
    }
}
