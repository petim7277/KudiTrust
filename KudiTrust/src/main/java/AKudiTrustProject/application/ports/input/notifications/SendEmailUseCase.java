package AKudiTrustProject.application.ports.input.notifications;

import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SendEmailRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendEmailResponse;

public interface SendEmailUseCase {
    SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest);

}
