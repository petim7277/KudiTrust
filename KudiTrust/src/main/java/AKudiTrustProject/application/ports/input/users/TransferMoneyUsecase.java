package AKudiTrustProject.application.ports.input.users;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.TransferMoneyRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.TransferMoneyResponse;

public interface TransferMoneyUsecase {
    TransferMoneyResponse transferMoney (TransferMoneyRequest transferMoneyRequest);

}
