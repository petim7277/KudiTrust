package AKudiTrustProject.domain.kudi_user_exceptions;

import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;
import org.springframework.http.HttpStatus;

public class KudiUserAlreadyExistException extends KudiTrustExceptions {
    public KudiUserAlreadyExistException() {}
    public KudiUserAlreadyExistException(String message) {}

    public KudiUserAlreadyExistException(String aKudiUserWithThisEmailAlreadyExist, HttpStatus httpStatus) {
    }
}
