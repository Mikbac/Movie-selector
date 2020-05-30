package pl.uam.movieSelector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 21.05.2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOMDBModelException extends RuntimeException {
    public InvalidOMDBModelException() {
        super("Invalid OMDB object from API!");
    }
}