package pl.uam.movieselector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 12.06.2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataQuantityException extends RuntimeException {
    public InvalidDataQuantityException(Long quantity) {
        super("Less than " + quantity + " in database.");
    }
}