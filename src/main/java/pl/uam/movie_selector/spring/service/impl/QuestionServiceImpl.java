package pl.uam.movie_selector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movie_selector.model.QuestionModel;
import pl.uam.movie_selector.spring.repository.QuestionRepository;
import pl.uam.movie_selector.spring.service.QuestionService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by MikBac on 22.05.2020
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionRepository questionRepository;

    @Override
    public ArrayList<QuestionModel> getAllQueries() {
        return questionRepository.findAll();
    }
}
