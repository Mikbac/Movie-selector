package pl.uam.movieSelector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.uam.movieSelector.model.OMDBMovieModel;

import java.util.ArrayList;

public interface OMDBMovieRepository extends CrudRepository<OMDBMovieModel, String>, PagingAndSortingRepository<OMDBMovieModel, String> {

    ArrayList<OMDBMovieModel> findAll();

}
