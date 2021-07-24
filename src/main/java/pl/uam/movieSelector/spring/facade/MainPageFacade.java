package pl.uam.movieSelector.spring.facade;

import pl.uam.movieSelector.data.impl.MovieData;
import pl.uam.movieSelector.data.impl.UserQuestionData;

import java.util.List;

/**
 * Created by MikBac on 22.05.2020
 */

public interface MainPageFacade {

    List<UserQuestionData> getAllQueries();

    List<MovieData> predictMovie(final List<UserQuestionData> questions, final int nTopMovies);

}
