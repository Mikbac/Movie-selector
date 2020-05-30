package pl.uam.movieSelector.spring.service.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
import pl.uam.movieSelector.data.impl.MovieData;
import pl.uam.movieSelector.data.impl.UserQuestionData;
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

import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.positiveOne;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.positiveThree;
import static pl.uam.movieSelector.constants.FuzzyLogicConstants.ValuePostfix.positiveTwo;

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
    public synchronized ArrayList<MovieData> predictUserAnswers(final ArrayList<UserQuestionData> userQuestions, final int nTopMovies) {
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
                        String date = omdbMovieRepository.findByImdbID(movie.getId())
                                .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                .getReleased();
                        fis.setVariable(question.getVariableName(), Integer.parseInt(date.substring(date.length() - 4)));
                        break;
                    case TOTAL_SEASONS:
                        try {
                            fis.setVariable(question.getVariableName(), Integer.parseInt(omdbMovieRepository.findByImdbID(movie.getId())
                                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                    .getTotalSeasons()));
                        } catch (Exception e) {
                            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
                        }
                        break;
                    case RUN_TIME:
                        fis.setVariable(question.getVariableName(), Integer.parseInt(omdbMovieRepository.findByImdbID(movie.getId())
                                .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                .getRuntime().split("\\s+")[0]));
                        break;
                    case IMDB_VOTES:
                        try {
                            fis.setVariable(question.getVariableName(), Long.parseLong(omdbMovieRepository.findByImdbID(movie.getId())
                                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                    .getImdbVotes().replaceAll(",", "")));
                        } catch (Exception e) {
                            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
                        }
                        break;
                    case METASCORE:
                        try {
                            fis.setVariable(question.getVariableName(), Long.parseLong(omdbMovieRepository.findByImdbID(movie.getId())
                                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                    .getMetascore()));
                        } catch (Exception e) {
                            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
                        }
                        break;
                    case QUANTITY_LANGUAGES:
                        try {
                            fis.setVariable(question.getVariableName(), omdbMovieRepository.findByImdbID(movie.getId())
                                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                    .getLanguage().split(",").length);
                        } catch (Exception e) {
                            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
                        }
                        break;
                    case QUANTITY_COUNTRIES:
                        try {
                            fis.setVariable(question.getVariableName(), omdbMovieRepository.findByImdbID(movie.getId())
                                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                                    .getCountry().split(",").length);
                        } catch (Exception e) {
                            fis.setVariable(question.getVariableName(), userQuestion.getRealUserAnswerValue() - (question.getGoodValueRange() / 2));
                        }
                        break;
                }
                fis.setVariable(question.getVariableName() + positiveOne, userQuestion.getRealUserAnswerValue() - userQuestion.getRealUserAnswerValue());
                fis.setVariable(question.getVariableName() + positiveTwo, userQuestion.getRealUserAnswerValue());
                fis.setVariable(question.getVariableName() + positiveThree, userQuestion.getRealUserAnswerValue() + userQuestion.getRealUserAnswerValue());
            }
            fis.evaluate();
            double movieScore = getScore(fis);
            log.info("Predict movie: {} ({}) - score: {}", movie::getName, movie::getId, () -> movieScore);
            movie.setScore(movieScore);
            movieRepository.save(movie);
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

    private ArrayList<MovieData> getNMoviesWithTheBestScore(final int n) {

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


