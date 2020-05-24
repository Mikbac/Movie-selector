package pl.uam.movieSelector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMovieException extends RuntimeException {
    public InvalidMovieException(String id) {
        super("Cannot find movie with id: " + id);
    }
}