package pl.uam.movie_selector.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uam.movie_selector.WebApplication;
import pl.uam.movie_selector.data.enums.AnswerEnum;
import pl.uam.movie_selector.data.impl.UserQuestionData;

import javax.annotation.Resource;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * Created by MikBac on 04.01.2022
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@AutoConfigureMockMvc
public class FuzzyLogicServiceTest {

    @Resource
    private FuzzyLogicService fuzzyLogicService;

    @Test
    public void predict_user_answers() {

        ArrayList<UserQuestionData> userAnswers = new ArrayList<>();

        UserQuestionData answerOne = new UserQuestionData();
        answerOne.setPk(1L);
        answerOne.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerOne.setRealUserAnswerValue(25.0);
        userAnswers.add(answerOne);

        UserQuestionData answerTwo = new UserQuestionData();
        answerTwo.setPk(2L);
        answerTwo.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerTwo.setRealUserAnswerValue(25.0);
        userAnswers.add(answerTwo);

        UserQuestionData answerThree = new UserQuestionData();
        answerThree.setPk(3L);
        answerThree.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerThree.setRealUserAnswerValue(25.0);
        userAnswers.add(answerThree);

        UserQuestionData answerFour = new UserQuestionData();
        answerFour.setPk(4L);
        answerFour.setUserAnswer(AnswerEnum.DEGREE_FOUR);
        answerFour.setRealUserAnswerValue(25.0);
        userAnswers.add(answerFour);

        UserQuestionData answerFive = new UserQuestionData();
        answerFive.setPk(5L);
        answerFive.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerFive.setRealUserAnswerValue(25.0);
        userAnswers.add(answerFive);

        UserQuestionData answerSix = new UserQuestionData();
        answerSix.setPk(6L);
        answerSix.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerSix.setRealUserAnswerValue(25.0);
        userAnswers.add(answerSix);

        UserQuestionData answerSeven = new UserQuestionData();
        answerSeven.setPk(7L);
        answerSeven.setUserAnswer(AnswerEnum.DEGREE_ONE);
        answerSeven.setRealUserAnswerValue(25.0);
        userAnswers.add(answerSeven);

        assertNotNull(fuzzyLogicService.predictUserAnswers(userAnswers, 5));

    }
}