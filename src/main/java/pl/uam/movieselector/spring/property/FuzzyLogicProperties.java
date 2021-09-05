package pl.uam.movieselector.spring.property;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by MikBac on 28.04.2021
 */

@ConfigurationProperties(prefix = "fuzzy.logic.controller")
@Getter
@Setter
public class FuzzyLogicProperties {

    @NonNull
    private String path;

}
