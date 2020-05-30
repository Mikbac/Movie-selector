package pl.uam.movieSelector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.exception.InvalidOMDBModelException;
import pl.uam.movieSelector.spring.repository.MovieRepository;
import pl.uam.movieSelector.spring.repository.OMDBMovieRepository;
import pl.uam.movieSelector.spring.repository.OMDBRepository;
import pl.uam.movieSelector.spring.service.OMDBMovieService;

import javax.annotation.Resource;

/**
 * Created by MikBac on 25.05.2020
 */

@Service
public class OMDBMovieServiceImpl implements OMDBMovieService {

    @Resource
    private MovieRepository movieRepository;

    @Resource
    private OMDBRepository omdbRepository;

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void LoadOMDBMovie() {
        movieRepository.findAll()
                .forEach(m -> omdbMovieRepository.save(omdbRepository.getMovieById(m.getId())
                        .orElseThrow(InvalidOMDBModelException::new)));
    }

}
