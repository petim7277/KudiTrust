package AKudiTrustProject.application.ports.input.transactions;

import java.math.BigDecimal;

public interface GetAccountBalanceUseCase {
    BigDecimal getAccountBalance (BigDecimal balance);

}
