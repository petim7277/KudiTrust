package AKudiTrustProject.domain.kudi_user_exceptions;

import AKudiTrustProject.domain.exceptions.KudiTrustExceptions;

public class InvalidInputFieldsException  extends KudiTrustExceptions {
    public InvalidInputFieldsException() {
        super();
    }
    public InvalidInputFieldsException(String message) {
        super(message);
    }
}
