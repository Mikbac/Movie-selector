package pl.uam.movie_selector.constants;

/**
 * Created by MikBac on 21.05.2020
 */

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

    interface OMDBRating {
        String SOURCE = "Source";
        String VALUE = "value";
    }

    interface OMDBMovie {
        String TITLE = "Title";
        String YEAR = "Year";
        String RATED = "Rated";
        String RELEASE = "Released";
        String RUNTIME = "Runtime";
        String GENRE = "Genre";
        String DIRECTOR = "Director";
        String WRITER = "Writer";
        String ACTORS = "Actors";
        String PLOT = "Plot";
        String LANGUAGE = "Language";
        String COUNTRY = "Country";
        String AWARDS = "Awards";
        String POSTER = "Poster";
        String RATINGS = "Ratings";
        String METASCORE = "Metascore";
        String IMDB_RATING = "imdbRating";
        String IMDB_VOTES = "imdbVotes";
        String TYPE = "Type";
        String DVD = "DVD";
        String BOX_OFFICE = "BoxOffice";
        String PRODUCTION = "Production";
        String WEBSITE = "Website";
        String RESPONSE = "Response";
        String TOTAL_SEASONS = "totalSeasons";
    }

}
