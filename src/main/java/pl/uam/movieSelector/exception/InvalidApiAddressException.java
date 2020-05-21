package pl.uam.movieSelector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidApiAddressException extends RuntimeException {
    public InvalidApiAddressException(String url) {
        super("Invalid API address for url: " + url);
    }
}