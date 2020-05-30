package pl.uam.movieSelector.spring.facade;

import pl.uam.movieSelector.data.impl.UserQuestionData;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface MainPageFacade {

    ArrayList<UserQuestionData> getAllQueries();

    ArrayList<String> predictMovie(ArrayList<UserQuestionData> questions);

}
