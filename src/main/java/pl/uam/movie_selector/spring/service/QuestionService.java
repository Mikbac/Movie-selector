package pl.uam.movie_selector.spring.service;

import pl.uam.movie_selector.model.QuestionModel;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface QuestionService {

    ArrayList<QuestionModel> getAllQueries();

}
