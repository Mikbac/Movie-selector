package pl.uam.movie_selector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

import static pl.uam.movie_selector.constants.EntityConstants.OMDBRating;

/**
 * Created by MikBac on 21.05.2020
 */

@Data
@Embeddable
public class OMDBRatingModel {

    @JsonProperty(OMDBRating.SOURCE)
    private String source;

    @JsonProperty(OMDBRating.VALUE)
    private String value;

}
