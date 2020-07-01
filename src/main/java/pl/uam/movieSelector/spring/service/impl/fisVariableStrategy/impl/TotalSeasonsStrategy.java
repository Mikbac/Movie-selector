package pl.uam.movieSelector.spring.service.impl.fisVariableStrategy.impl;

import lombok.extern.log4j.Log4j2;
import net.sourceforge.jFuzzyLogic.FIS;
import org.springframework.stereotype.Service;
import pl.uam.movieSelector.exception.InvalidMovieException;
import pl.uam.movieSelector.model.MovieModel;
import pl.uam.movieSelector.model.QuestionModel;
import pl.uam.movieSelector.spring.repository.OMDBMovieRepository;
import pl.uam.movieSelector.spring.service.impl.fisVariableStrategy.FisVariableStrategy;

import javax.annotation.Resource;

/**
 * Created by MikBac on 30.06.2020
 */

@Log4j2
@Service
public class TotalSeasonsStrategy implements FisVariableStrategy {

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void setFisVariable(final FIS fis, final QuestionModel question, final MovieModel movie) {
        try {
            final int movieTotalSeasons = Integer.parseInt(omdbMovieRepository.findByImdbID(movie.getId())
                    .orElseThrow(() -> new InvalidMovieException(movie.getId()))
                    .getTotalSeasons());
            fis.setVariable(question.getVariableName(), movieTotalSeasons);
            log.info("Movie: {},  Total seasons variable: {}", movie.getName(), movieTotalSeasons);
        } catch (Exception e) {
            fis.setVariable(question.getVariableName(), 0);
            log.info("Movie: {},  Total seasons variable: {}", movie.getName(), 0);
        }
    }

}
