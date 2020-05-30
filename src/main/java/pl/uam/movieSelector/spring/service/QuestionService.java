package pl.uam.movieSelector.spring.service;

import pl.uam.movieSelector.model.QuestionModel;

import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

public interface QuestionService {

    ArrayList<QuestionModel> getAllQueries();

}
