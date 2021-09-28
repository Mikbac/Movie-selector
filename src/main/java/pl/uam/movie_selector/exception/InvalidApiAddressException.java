package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 21.05.2020
 */

public class InvalidApiAddressException extends RuntimeException {
    public InvalidApiAddressException(String url) {
        super("Invalid API address for url: " + url);
    }
}