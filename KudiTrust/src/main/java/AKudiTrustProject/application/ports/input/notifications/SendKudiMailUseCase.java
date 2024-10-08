package AKudiTrustProject.application.ports.input.notifications;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendKudiEmailRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendKudiEmailResponse;

public interface SendKudiMailUseCase {
    SendKudiEmailResponse sendKudiMail(SendKudiEmailRequest sendKudiEmailRequest);

}
