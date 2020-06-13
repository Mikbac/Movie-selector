package pl.uam.movieSelector.spring.service.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.MovieData;
import pl.uam.movieSelector.data.impl.UserQuestionData;
import pl.uam.movieSelector.exception.InvalidDataQuantityException;
import pl.uam.movieSelector.exception.InvalidMovieException;
import pl.uam.movieSelector.exception.InvalidQuestionException;
import pl.uam.movieSelector.model.MovieModel;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.repository.FuzzyLogicRepository;
import pl.uam.movieSelector.spring.repository.MovieRepository;
import pl.uam.movieSelector.spring.repository.OMDBMovieRepository;
import pl.uam.movieSelector.spring.repository.QuestionRepository;
import pl.uam.movieSelector.spring.service.FuzzyLogicService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_FIVE;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_FOUR;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_ONE;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_SEVEN;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_SIX;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_THREE;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.POSITIVE_TWO;

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

    @Override
    public synchronized ArrayList<MovieData> predictUserAnswers(final ArrayList<UserQuestionData> userQuestions, final long nTopMovies) {
        setRealUserAnswerVariables(userQuestions);
        predictAllMovies(userQuestions);

        return getNMoviesWithTheBestScore(nTopMovies);
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
                        setFisVariableReleased(fis, question, movie, userQuestion);
                        break;
                    case TOTAL_SEASONS:
                        setFisVariableTotalSeasons(fis, question, movie, userQuestion);
                        break;
                    case RUN_TIME:
                        setFisVariableRunTime(fis, question, movie, userQuestion);
                        break;
                    case IMDB_VOTES:
                        setFisVariableIMDBVotes(fis, question, movie, userQuestion);
                        break;
                    case METASCORE:
                        setFisVariableMetascore(fis, question, movie, userQuestion);
                        break;
                    case QUANTITY_LANGUAGES:
                        setFisVariableQuantityLanguages(fis, question, movie, userQuestion);
                        break;
                    case QUANTITY_COUNTRIES:
                        setFisVariableQuantityCountries(fis, question, movie, userQuestion);
                        break;
                }
                setFisVariables(question, userQuestion, fis);
            }
            fis.evaluate();
            double movieScore = getScore(fis);
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

    private void setFisVariableReleased(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        String date = omdbMovieRepository.findByImdbID(movie.getId())
                .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                .getReleased();
        fis.setVariable(question.getVariableName(), Integer.parseInt(date.substring(date.length() - 4)));
    }

    private void setFisVariableTotalSeasons(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), Integer.parseInt(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getTotalSeasons()));
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setFisVariableRunTime(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), Integer.parseInt(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getRuntime().split("\\s+")[0]));
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setFisVariableIMDBVotes(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), Long.parseLong(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getImdbVotes().replaceAll(",", "")));
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setFisVariableMetascore(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), Long.parseLong(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getMetascore()));
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setFisVariableQuantityLanguages(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getLanguage().split(",").length);
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setFisVariableQuantityCountries(final FIS fis, final QuestionModel question, final MovieModel movie, UserQuestionData userQuestion) {
        try {
            fis.setVariable(question.getVariableName(), omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getCountry().split(",").length);
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
        }
    }

    private void setRealUserAnswerVariables(final ArrayList<UserQuestionData> userQuestions) {
        for (UserQuestionData userQuestion : userQuestions) {

            QuestionModel question = getQuestionByUserQuestions(userQuestion);
            double increasingValue = (question.getEndVariable() - question.getStartVariable()) / 5;

            switch (userQuestion.getUserAnswer()) {
                case DEGREE_ONE:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable());
                    break;
                case DEGREE_TWO:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable() + increasingValue);
                    break;
                case DEGREE_THREE:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable() + (increasingValue * 2));
                    break;
                case DEGREE_FOUR:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable() + (increasingValue * 3));
                    break;
                case DEGREE_FIVE:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable() + (increasingValue * 4));
                    break;
                case DEGREE_SIX:
                    userQuestion.setRealUserAnswerValue(question.getStartVariable() + (increasingValue * 5));
                    break;
            }
        }
    }

    private QuestionModel getQuestionByUserQuestions(final UserQuestionData userQuestion) {
        return questionRepository.findAll()
                .stream()
                .filter(q -> userQuestion.getPk().equals(q.getPk()))
                .findAny()
                .orElseThrow(() -> new InvalidQuestionException(userQuestion.getPk()));
    }

    private double getScore(final FIS fis) {
        fis.evaluate();
        return fis.getVariable("score").getValue();
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


