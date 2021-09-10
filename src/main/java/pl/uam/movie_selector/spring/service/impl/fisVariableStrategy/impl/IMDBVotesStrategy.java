package pl.uam.movie_selector.spring.service.impl.fisVariableStrategy.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
import pl.uam.movie_selector.exception.InvalidMovieException;
import pl.uam.movie_selector.model.MovieModel;
import pl.uam.movie_selector.model.QuestionModel;
import pl.uam.movie_selector.spring.repository.OMDBMovieRepository;
import pl.uam.movie_selector.spring.service.impl.fisVariableStrategy.FisVariableStrategy;

import javax.annotation.Resource;

/**
 * Created by MikBac on 30.06.2020
 */

@Log4j2
@Service
public class IMDBVotesStrategy implements FisVariableStrategy {

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie) {
        try {
            final long movieIMDBVotes = Long.parseLong(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getImdbVotes().replaceAll(",", ""));
            fis.setVariable(question.getVariableName(), movieIMDBVotes);
            log.info("Movie: {},  IMDB votes variable: {}", movie.getName(), movieIMDBVotes);
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), 0);
            log.info("Movie: {},  IMDB votes variable: {}", movie.getName(), 0);
        }
    }

}
