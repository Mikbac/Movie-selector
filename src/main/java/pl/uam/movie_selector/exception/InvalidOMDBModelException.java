package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 21.05.2020
 */

public class InvalidOMDBModelException extends RuntimeException {
    public InvalidOMDBModelException() {
        super("Invalid OMDB object from API!");
    }
}