package pl.uam.movieSelector.constants;

public interface EntityConstants {

    interface Model {
        String PK = "pk";
    }

    interface Movie {
        String TABLE = "Movie";
        String PK = "pk";
        String ID = "id";
        String NAME = "name";
        String SCORE = "score";
    }

    interface Question {
        String TABLE = "Question";
        String PK = "pk";
        String DESCRIPTION = "description";
        String BASE_MOVIE_VARIABLE = "baseMovieVariable";
        String VARIABLE_NAME = "variableName";
        String POOR_VARIABLE = "poorVariable";
        String FAIR_VARIABLE = "fairVariable";
        String GOOD_VARIABLE = "goodVariable";
    }

}
