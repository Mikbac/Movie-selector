package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 25.05.2020
 */

public class InvalidQuestionException extends RuntimeException {
    public InvalidQuestionException(Long id) {
        super("Cannot find question with id: " + id);
    }
}