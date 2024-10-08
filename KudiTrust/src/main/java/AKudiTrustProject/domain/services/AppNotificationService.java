package AKudiTrustProject.domain.services;

import AKudiTrustProject.application.ports.input.notifications.SendEmailUseCase;
import AKudiTrustProject.application.ports.input.notifications.SendKudiMailUseCase;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.requests.SendEmailRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendEmailResponse;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendKudiEmailRequest;
import AKudiTrustProject.infrastucture.adapters.input.rest.data.responses.SendKudiEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class AppNotificationService implements SendEmailUseCase, SendKudiMailUseCase {
    @Override
    public SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest) {
        return null;
    }

    @Override
    public SendKudiEmailResponse sendKudiMail(SendKudiEmailRequest sendKudiEmailRequest) {
        return null;
    }
}
