package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 25.05.2020
 */

public class InvalidMovieException extends RuntimeException {
    public InvalidMovieException(String id) {
        super("Cannot find movie with id: " + id);
    }
}