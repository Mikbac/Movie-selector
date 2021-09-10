package pl.uam.movie_selector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by MikBac on 25.05.2020
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException(Long id) {
        super("Cannot find question with id: " + id);
    }
}