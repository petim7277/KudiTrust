package AKudiTrustProject.domain.exceptions;

import org.springframework.http.HttpStatus;

public class KudiTrustExceptions extends RuntimeException{
    public KudiTrustExceptions() {
    }

    public KudiTrustExceptions(String message) {

    }


    public KudiTrustExceptions(String kudiUserCreationFailed, HttpStatus httpStatus) {
    }
}
