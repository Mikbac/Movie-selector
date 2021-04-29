package pl.uam.movieSelector.spring.property;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by MikBac on 28.04.2021
 */

@ConfigurationProperties(prefix = "omdb.api")
@Getter
@Setter
public class OmdbProperties {

    @NonNull
    private String key;

}
