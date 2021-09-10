package pl.uam.movie_selector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movie_selector.exception.InvalidOMDBModelException;
import pl.uam.movie_selector.spring.repository.MovieRepository;
import pl.uam.movie_selector.spring.repository.OMDBMovieRepository;
import pl.uam.movie_selector.spring.repository.OMDBRepository;
import pl.uam.movie_selector.spring.service.OMDBMovieService;

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
