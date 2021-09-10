package pl.uam.movie_selector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movie_selector.constants.EntityConstants.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by MikBac on 21.05.2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = Movie.TABLE)
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = Movie.PK)
    private Long pk;

    @Column(name = Movie.NAME)
    private String name;

    @Column(name = Movie.ID)
    private String id;

    @Column(name = Movie.SCORE)
    private BigDecimal score;

}
