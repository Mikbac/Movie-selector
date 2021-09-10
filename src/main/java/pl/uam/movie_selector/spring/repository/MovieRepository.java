package pl.uam.movie_selector.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.uam.movie_selector.model.MovieModel;

import java.util.ArrayList;

/**
 * Created by MikBac on 21.05.2020
 */

@Repository
public interface MovieRepository extends CrudRepository<MovieModel, Integer>, PagingAndSortingRepository<MovieModel, Integer> {

    ArrayList<MovieModel> findAll();

}
