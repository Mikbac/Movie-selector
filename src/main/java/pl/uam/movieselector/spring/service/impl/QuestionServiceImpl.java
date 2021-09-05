package pl.uam.movieselector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieselector.model.QuestionModel;
import pl.uam.movieselector.spring.repository.QuestionRepository;
import pl.uam.movieselector.spring.service.QuestionService;

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
