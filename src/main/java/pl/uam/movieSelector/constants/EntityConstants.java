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
        String BASE_MOVIE_VARIABLE = "base_movie_variable";
        String VARIABLE_NAME = "variable_name";
        String START_VARIABLE = "start_variable";
        String END_VARIABLE = "end_variable";
        String GOOD_VALUE_RANGE = "good_value_range";
    }

}
