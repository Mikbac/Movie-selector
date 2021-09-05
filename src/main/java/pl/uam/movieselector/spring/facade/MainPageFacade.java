package pl.uam.movieselector.spring.facade;

import pl.uam.movieselector.data.impl.MovieData;
import pl.uam.movieselector.data.impl.UserQuestionData;

import java.util.List;

/**
 * Created by MikBac on 22.05.2020
 */

public interface MainPageFacade {

    List<UserQuestionData> getAllQueries();

    List<MovieData> predictMovie(final List<UserQuestionData> questions, final int nTopMovies);

}
