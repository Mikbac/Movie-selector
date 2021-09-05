package pl.uam.movieselector.spring.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;

/**
 * Created by MikBac on 28.04.2021
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "omdb.api")
public class OmdbProperties {

    @NonNull
    private String url;

    @NonNull
    private String key;

}
