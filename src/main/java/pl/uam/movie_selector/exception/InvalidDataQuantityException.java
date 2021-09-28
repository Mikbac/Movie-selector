package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 12.06.2020
 */

public class InvalidDataQuantityException extends RuntimeException {
    public InvalidDataQuantityException(Long quantity) {
        super("Less than " + quantity + " in database.");
    }
}