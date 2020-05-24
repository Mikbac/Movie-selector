package pl.uam.movieSelector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException(Long id) {
        super("Cannot find question with id: " + id);
    }
}