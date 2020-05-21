package pl.uam.movieSelector.spring.service.impl;

import org.springframework.stereotype.Service;
import pl.uam.movieSelector.exception.InvalidOMDBModelException;
import pl.uam.movieSelector.model.MovieModel;
import pl.uam.movieSelector.model.OMDBMovieModel;
import pl.uam.movieSelector.spring.repository.MovieRepository;
import pl.uam.movieSelector.spring.repository.OMDBMovieRepository;
import pl.uam.movieSelector.spring.repository.OMDBRepository;
import pl.uam.movieSelector.spring.service.FuzzyLogicService;

import javax.annotation.Resource;

@Service
public class FuzzyLogicServiceImpl implements FuzzyLogicService {

    @Resource
    private MovieRepository movieRepository;

    @Resource
    private OMDBRepository omdbRepository;

    @Resource
    private OMDBMovieRepository omdbMovieRepository;

    @Override
    public void ClassifyOMDBMovie() {

        movieRepository.findAll()
                .forEach(m -> omdbMovieRepository.save(omdbRepository.getMovieById(m.getId())
                        .orElseThrow(InvalidOMDBModelException::new)));

        //TODO skonczone na zapisywaniu wyniku z OMDB do DB

        }

    }


