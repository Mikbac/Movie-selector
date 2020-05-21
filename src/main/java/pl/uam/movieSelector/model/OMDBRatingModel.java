package pl.uam.movieSelector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class OMDBRatingModel {

    @JsonProperty("Source")
    private String Source;
    @JsonProperty("value")
    private String value;

}
