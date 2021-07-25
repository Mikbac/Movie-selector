package pl.uam.movieSelector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by MikBac on 21.05.2020
 */

@Data
@Embeddable
public class OMDBRatingModel {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("value")
    private String value;

}
