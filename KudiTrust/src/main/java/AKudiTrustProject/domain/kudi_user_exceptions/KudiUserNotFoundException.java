package AKudiTrustProject.domain.kudi_user_exceptions;

import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;
import org.springframework.http.HttpStatus;

public class KudiUserNotFoundException extends KudiTrustExceptions {
    public KudiUserNotFoundException() {}
    public KudiUserNotFoundException(String message) {}

    public KudiUserNotFoundException(String kudiUserNotFound, HttpStatus httpStatus) {
    }
}
