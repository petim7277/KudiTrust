package AKudiTrustProject.services;

import AKudiTrustProject.dtos.requests.SendEmailRequest;
import AKudiTrustProject.dtos.responses.SendEmailResponse;
import AKudiTrustProject.dtos.responses.SendKudiEmailRequest;
import AKudiTrustProject.dtos.responses.SendKudiEmailResponse;

public interface AppNotificationService {
     SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest);
     SendKudiEmailResponse sendKudiMail(SendKudiEmailRequest sendKudiEmailRequest);
}
