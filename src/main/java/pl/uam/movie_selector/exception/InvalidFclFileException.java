package pl.uam.movie_selector.exception;

/**
 * Created by MikBac on 25.05.2020
 */

public class InvalidFclFileException extends RuntimeException {
    public InvalidFclFileException(String filename) {
        super("Cannot load fcl file: " + filename);
    }
}