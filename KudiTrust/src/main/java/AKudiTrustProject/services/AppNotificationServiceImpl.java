package AKudiTrustProject.services;

import AKudiTrustProject.dtos.requests.SendEmailRequest;
import AKudiTrustProject.dtos.responses.SendEmailResponse;
import AKudiTrustProject.dtos.responses.SendKudiEmailRequest;
import AKudiTrustProject.dtos.responses.SendKudiEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class AppNotificationServiceImpl implements AppNotificationService{
    @Override
    public SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest) {
        return null;
    }

    @Override
    public SendKudiEmailResponse sendKudiMail(SendKudiEmailRequest sendKudiEmailRequest) {
        return null;
    }
}
