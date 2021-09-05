package pl.uam.movieselector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 25.05.2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFclFileException extends RuntimeException {
    public InvalidFclFileException(String filename) {
        super("Cannot load fcl file: " + filename);
    }
}