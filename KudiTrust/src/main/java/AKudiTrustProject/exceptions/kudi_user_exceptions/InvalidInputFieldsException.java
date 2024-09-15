package AKudiTrustProject.exceptions.kudi_user_exceptions;

import AKudiTrustProject.exceptions.ErrorMessages;
import AKudiTrustProject.exceptions.KudiTrustExceptions;

public class InvalidInputFieldsException  extends KudiTrustExceptions {
    public InvalidInputFieldsException() {
        super();
    }
    public InvalidInputFieldsException(String message) {
        super(message);
    }
}
