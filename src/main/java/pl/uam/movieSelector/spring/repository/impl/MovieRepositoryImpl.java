package pl.uam.movieSelector.spring.repository.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.uam.movieSelector.model.MovieModel;

@Repository
public interface MovieRepositoryImpl extends CrudRepository<MovieModel, Integer>, PagingAndSortingRepository<MovieModel, Integer> {

}
