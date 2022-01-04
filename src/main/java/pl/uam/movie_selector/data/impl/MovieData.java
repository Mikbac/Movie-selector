package pl.uam.movie_selector.data.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.uam.movie_selector.data.Data;

import java.math.BigDecimal;

/**
 * Created by MikBac on 30.05.2020
 */

@Builder
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieData implements Data {

    private String name;
    private BigDecimal score;

}
