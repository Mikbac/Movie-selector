package pl.uam.movieSelector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFclFileException extends RuntimeException {
    public InvalidFclFileException(String filename) {
        super("Cannot load fcl file: " + filename);
    }
}