package pl.uam.movieSelector.spring.service.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
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
    public synchronized String predictUserAnswers(ArrayList<UserQuestionData> userQuestions) {
        final FIS fis = fuzzyLogicRepository.getFIS();
        addUserVariables(fis, userQuestions);
        return getMovieWithTheBestScore(getScore(fis));

    }

    @Override
    public void predictAllMovies() {
        final FIS fis = fuzzyLogicRepository.getFIS();
        for (MovieModel movie : movieRepository.findAll()) {
            for (QuestionModel question : questionRepository.findAll()) {
                log.info("Predict {} ({})", movie::getName, movie::getId);
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
                            fis.setVariable(question.getVariableName(), 0);
                        }
                        break;

                }
                movie.setScore(getScore(fis));
                movieRepository.save(movie);
            }

        }

    }

    private void addUserVariables(final FIS fis, final ArrayList<UserQuestionData> userQuestions) {
        for (UserQuestionData userQuestion : userQuestions) {

            QuestionModel question = getQuestionByUserQuestions(userQuestion);

            switch (userQuestion.getUserAnswer()) {
                case POOR:
                    fis.setVariable(question.getVariableName(), question.getPoorVariable());
                    break;
                case FAIR:
                    fis.setVariable(question.getVariableName(), question.getFairVariable());
                    break;
                case GOOD:
                    fis.setVariable(question.getVariableName(), question.getGoodVariable());
                    break;
            }
        }
    }

    private QuestionModel getQuestionByUserQuestions(UserQuestionData userQuestion) {
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

    private String getMovieWithTheBestScore(double userScore) {
        double bestScore = 100;
        String bestScoreMovieTitle = null;

        for (MovieModel movie : movieRepository.findAll()) {
            double newScore = Math.abs(userScore - movie.getScore());
            if (newScore < bestScore) {
                bestScore = newScore;
                bestScoreMovieTitle = movie.getName();
            }
        }
        return bestScoreMovieTitle;
    }
}


