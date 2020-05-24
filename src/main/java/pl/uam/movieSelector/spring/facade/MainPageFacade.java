package pl.uam.movieSelector.spring.facade;

import pl.uam.movieSelector.data.impl.QuestionData;

import java.util.ArrayList;

public interface MainPageFacade {

    ArrayList<QuestionData> getAllQueries();

    String predictMovie(ArrayList<QuestionData> questions);

}
