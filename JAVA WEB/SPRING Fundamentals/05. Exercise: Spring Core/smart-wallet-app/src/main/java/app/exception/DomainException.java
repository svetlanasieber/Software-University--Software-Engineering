package app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DomainException extends RuntimeException {

    private final String message;
    private final HttpStatus status;

    public DomainException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
