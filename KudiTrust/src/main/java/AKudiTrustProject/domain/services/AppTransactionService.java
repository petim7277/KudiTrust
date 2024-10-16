package AKudiTrustProject.domain.services;

import AKudiTrustProject.application.ports.input.transactions.GetAccountBalanceUseCase;
import AKudiTrustProject.application.ports.input.transactions.StartTransactionUseCase;
import AKudiTrustProject.application.ports.input.transactions.TerminateTransactionUseCase;
import AKudiTrustProject.application.ports.input.transactions.ViewTransactionHistoryUseCase;
import AKudiTrustProject.infrastucture.adapters.config.paystack_config.PaystackConfig;
import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import AKudiTrustProject.infrastucture.adapters.output.persistence.repositories.AppUserRepository;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.CancelTransactionRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.InitializeTransactionRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.ViewTransactionHistoryRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.CancelTransactionResponse;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.InitializeTransactionResponse;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.ViewTransactionHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppTransactionService implements StartTransactionUseCase, GetAccountBalanceUseCase, ViewTransactionHistoryUseCase, TerminateTransactionUseCase {

    private final PaystackConfig paystackConfig;
    private final AppUserRepository appUserRepository;
    @Override
    public InitializeTransactionResponse startTransaction(InitializeTransactionRequest transactionRequest) {
        RestTemplate restTemplate = new RestTemplate();
        InitializeTransactionResponse transactionResponse = new InitializeTransactionResponse();
        Optional<AppUserEntity> foundUser = appUserRepository.findAppUsersByEmail(transactionRequest.getEmail());
        if (foundUser.isPresent()) {
            HttpEntity<InitializeTransactionRequest> request = buildPayment(transactionRequest);
            ResponseEntity<InitializeTransactionResponse>  response = restTemplate
                    .postForEntity(paystackConfig.getPaystackBaseUrl(), request, InitializeTransactionResponse.class);
            return response.getBody();
        }
        transactionResponse.setMessage("Transaction has been successfully started");
        return transactionResponse;
    }

    private HttpEntity<InitializeTransactionRequest> buildPayment(InitializeTransactionRequest initializeTransactionRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+paystackConfig.getPaystackApiKey());
        return new HttpEntity<>(initializeTransactionRequest, headers);
    }
    @Override
    public BigDecimal getAccountBalance(BigDecimal balance) {
        return null;
    }

    @Override
    public ViewTransactionHistoryResponse viewTransactionHistory(ViewTransactionHistoryRequest transactionHistoryRequest) {
        return null;
    }

    @Override
    public CancelTransactionResponse terminateTransaction(CancelTransactionRequest cancelTransactionRequest) {
        return null;
    }
}
