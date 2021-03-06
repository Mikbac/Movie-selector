package pl.uam.movieSelector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uam.movieSelector.data.Data;

/**
 * Created by MikBac on 30.05.2020
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieData implements Data {

    private String name;
    private double score;

}
