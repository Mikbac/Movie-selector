package pl.uam.movieSelector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.repository.QuestionRepository;
import pl.uam.movieSelector.spring.service.QuestionService;

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
