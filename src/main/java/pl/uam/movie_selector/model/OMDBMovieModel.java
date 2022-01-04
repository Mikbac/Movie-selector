package pl.uam.movie_selector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static pl.uam.movie_selector.constants.EntityConstants.OMDBMovie;

/**
 * Created by MikBac on 21.05.2020
 */

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OMDBMovieModel implements Serializable {

    @Id
    private String imdbID;

    @JsonProperty(OMDBMovie.TITLE)
    private String title;

    @JsonProperty(OMDBMovie.YEAR)
    private String tear;

    @JsonProperty(OMDBMovie.RATED)
    private String rated;

    @JsonProperty(OMDBMovie.RELEASE)
    private String released;

    @JsonProperty(OMDBMovie.RUNTIME)
    private String runtime;

    @JsonProperty(OMDBMovie.GENRE)
    private String genre;

    @JsonProperty(OMDBMovie.DIRECTOR)
    private String director;

    @JsonProperty(OMDBMovie.WRITER)
    @Lob
    @Column(length = 1000)
    private String writer;

    @JsonProperty(OMDBMovie.ACTORS)
    private String actors;

    @JsonProperty(OMDBMovie.PLOT)
    @Lob
    @Column(length = 1000)
    private String plot;

    @JsonProperty(OMDBMovie.LANGUAGE)
    private String language;

    @JsonProperty(OMDBMovie.COUNTRY)
    private String country;

    @JsonProperty(OMDBMovie.AWARDS)
    private String awards;

    @JsonProperty(OMDBMovie.POSTER)
    private String poster;

    @JsonProperty(OMDBMovie.RATINGS)
    @Embedded
    @ElementCollection
    List<OMDBRatingModel> ratings = new ArrayList<>();

    @JsonProperty(OMDBMovie.METASCORE)
    private String metascore;

    @JsonProperty(OMDBMovie.IMDB_RATING)
    private String imdbRating;

    @JsonProperty(OMDBMovie.IMDB_VOTES)
    private String imdbVotes;

    @JsonProperty(OMDBMovie.TYPE)
    private String pype;

    @JsonProperty(OMDBMovie.DVD)
    private String dvd;

    @JsonProperty(OMDBMovie.BOX_OFFICE)
    private String boxOffice;

    @JsonProperty(OMDBMovie.PRODUCTION)
    private String production;

    @JsonProperty(OMDBMovie.WEBSITE)
    private String website;

    @JsonProperty(OMDBMovie.RESPONSE)
    private String response;

    @JsonProperty(OMDBMovie.TOTAL_SEASONS)
    private String totalSeasons;

}
