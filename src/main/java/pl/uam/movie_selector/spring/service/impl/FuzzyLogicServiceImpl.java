package pl.uam.movie_selector.spring.service.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;
import pl.uam.movie_selector.data.impl.MovieData;
import pl.uam.movie_selector.data.impl.UserQuestionData;
import pl.uam.movie_selector.exception.InvalidDataQuantityException;
import pl.uam.movie_selector.exception.InvalidQuestionException;
import pl.uam.movie_selector.model.MovieModel;
import pl.uam.movie_selector.model.QuestionModel;
import pl.uam.movie_selector.spring.repository.FuzzyLogicRepository;
import pl.uam.movie_selector.spring.repository.MovieRepository;
import pl.uam.movie_selector.spring.repository.OMDBMovieRepository;
import pl.uam.movie_selector.spring.repository.QuestionRepository;
import pl.uam.movie_selector.spring.service.FuzzyLogicService;
import pl.uam.movie_selector.spring.service.impl.fisVariableStrategy.FisVariableStrategy;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_FIVE;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_FOUR;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_ONE;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_SEVEN;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_SIX;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_THREE;
import static pl.uam.movie_selector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_TWO;

/**
 * Created by MikBac on 21.05.2020
 */

@Log4j2
@Service
public class FuzzyLogicServiceImpl implements FuzzyLogicService {

    @Resource
    private FuzzyLogicRepository fuzzyLogicRepository;

    @Resource
    private MovieRepository movieRepository;

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private BeanFactory beanFactory;

    @Override
    public synchronized ArrayList<MovieData> predictUserAnswers(final ArrayList<UserQuestionData> userQuestions, final long topMoviesQuantity) {
        setRealUserAnswerVariables(userQuestions);
        predictAllMovies(userQuestions);

        return getNMoviesWithTheBestScore(topMoviesQuantity);
    }

    private void predictAllMovies(final ArrayList<UserQuestionData> userQuestions) {
        FIS fis;
        QuestionModel question;
        for (MovieModel movie : movieRepository.findAll()) {
            fis = fuzzyLogicRepository.getFIS();
            for (UserQuestionData userQuestion : userQuestions) {
                question = getQuestionByUserQuestions(userQuestion);
                switch (question.getBaseVariable()) {
                    case RELEASED:
                        beanFactory.getBean("releasedStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case TOTAL_SEASONS:
                        beanFactory.getBean("totalSeasonsStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case RUN_TIME:
                        beanFactory.getBean("runTimeStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case IMDB_VOTES:
                        beanFactory.getBean("IMDBVotesStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case METASCORE:
                        beanFactory.getBean("metascoreStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case QUANTITY_LANGUAGES:
                        beanFactory.getBean("quantityLanguagesStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    case QUANTITY_COUNTRIES:
                        beanFactory.getBean("quantityCountriesStrategy", FisVariableStrategy.class).setFisVariable(fis, question, movie);
                        break;
                    default:
                        log.error("Unknown question variable: {}", question.getBaseVariable());
                        break;
                }
                setFisVariables(question, userQuestion, fis);
            }
            fis.evaluate();
            BigDecimal movieScore = getScore(fis);
            log.info("Predict movie: {} ({}) - score: {}", movie::getName, movie::getId, () -> movieScore);
            movie.setScore(movieScore);
            movieRepository.save(movie);
        }

    }

    private void setFisVariables(final QuestionModel question, final UserQuestionData userQuestion, final FIS fis) {
        fis.setVariable(question.getVariableName() + POSITIVE_ONE, userQuestion.getRealUserAnswerValue() - (3 * userQuestion.getRealUserAnswerValue()));
        fis.setVariable(question.getVariableName() + POSITIVE_TWO, userQuestion.getRealUserAnswerValue() - (2 * userQuestion.getRealUserAnswerValue()));
        fis.setVariable(question.getVariableName() + POSITIVE_THREE, userQuestion.getRealUserAnswerValue() - (1 * userQuestion.getRealUserAnswerValue()));
        fis.setVariable(question.getVariableName() + POSITIVE_FOUR, userQuestion.getRealUserAnswerValue());
        fis.setVariable(question.getVariableName() + POSITIVE_FIVE, userQuestion.getRealUserAnswerValue() + (1 * userQuestion.getRealUserAnswerValue()));
        fis.setVariable(question.getVariableName() + POSITIVE_SIX, userQuestion.getRealUserAnswerValue() + (2 * userQuestion.getRealUserAnswerValue()));
        fis.setVariable(question.getVariableName() + POSITIVE_SEVEN, userQuestion.getRealUserAnswerValue() + (3 * userQuestion.getRealUserAnswerValue()));
    }

    private void setRealUserAnswerVariables(final ArrayList<UserQuestionData> userQuestions) {
        for (UserQuestionData userQuestion : userQuestions) {

            QuestionModel question = getQuestionByUserQuestions(userQuestion);
            double increasingValue = (question.getEndVariable() - question.getStartVariable()) / 5;
            Double userAnswerVariable = null;
            switch (userQuestion.getUserAnswer()) {
                case DEGREE_ONE:
                    userAnswerVariable = question.getStartVariable();
                    break;
                case DEGREE_TWO:
                    userAnswerVariable = question.getStartVariable() + increasingValue;
                    break;
                case DEGREE_THREE:
                    userAnswerVariable = question.getStartVariable() + (increasingValue * 2);
                    break;
                case DEGREE_FOUR:
                    userAnswerVariable = question.getStartVariable() + (increasingValue * 3);
                    break;
                case DEGREE_FIVE:
                    userAnswerVariable = question.getStartVariable() + (increasingValue * 4);
                    break;
                case DEGREE_SIX:
                    userAnswerVariable = question.getStartVariable() + (increasingValue * 5);
                    break;
                default:
                    log.error("Unknown user answer degree: {}", userQuestion.getUserAnswer());
                    break;
            }
            userQuestion.setRealUserAnswerValue(userAnswerVariable);
            log.info("The user answer to the question: {} = {}", userQuestion.getDescription(), userAnswerVariable);
        }
    }

    private QuestionModel getQuestionByUserQuestions(final UserQuestionData userQuestion) {
        return questionRepository.findAll()
                .stream()
                .filter(q -> userQuestion.getPk().equals(q.getPk()))
                .findAny()
                .orElseThrow(() -> new InvalidQuestionException(userQuestion.getPk()));
    }

    private BigDecimal getScore(final FIS fis) {
        fis.evaluate();
        return BigDecimal.valueOf(fis.getVariable("score").getValue()).setScale(2, RoundingMode.CEILING);
    }

    private ArrayList<MovieData> getNMoviesWithTheBestScore(long n) {
        long movieQuantity = omdbMovieRepository.count();
        try {
            if (movieQuantity < n) {
                throw new InvalidDataQuantityException(n);
            }
        } catch (InvalidDataQuantityException e) {
            n = movieQuantity;
            log.warn("Updated results quantity from {} to {}!", n, movieQuantity);
        }

        ArrayList<MovieData> bestMovies = new ArrayList<>();
        ArrayList<MovieModel> movies = movieRepository.findAll();
        movies.sort(Comparator.comparing(MovieModel::getScore));
        Collections.reverse(movies);
        for (int i = 0; i < n; i++) {
            bestMovies.add(new MovieData(movies.get(i).getName(), movies.get(i).getScore()));
        }

        return bestMovies;
    }
}


