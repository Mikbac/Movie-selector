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
    }

    interface Question {
        String TABLE = "Question";
        String PK = "pk";
        String DESCRIPTION = "description";
        String USER_ANSWER = "userAnswer";
    }

}
