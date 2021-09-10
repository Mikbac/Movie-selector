package pl.uam.movie_selector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 21.05.2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidApiAddressException extends RuntimeException {
    public InvalidApiAddressException(String url) {
        super("Invalid API address for url: " + url);
    }
}