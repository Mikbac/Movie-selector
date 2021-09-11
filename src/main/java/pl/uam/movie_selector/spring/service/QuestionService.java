package pl.uam.movie_selector.spring.service;

import pl.uam.movie_selector.model.QuestionModel;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface QuestionService {

    /**
     * Get the list of all queries.
     *
     * @return list of all queries for user {@link QuestionModel}.
     */
    ArrayList<QuestionModel> getAllQueries();

}
