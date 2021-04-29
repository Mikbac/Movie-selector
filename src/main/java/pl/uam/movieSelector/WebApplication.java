package pl.uam.movieSelector;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.uam.movieSelector.spring.property.FuzzyLogicProperties;
import pl.uam.movieSelector.spring.property.OmdbProperties;

/**
 * Created by MikBac on 21.05.2020
 */

@Log4j2
@SpringBootApplication(scanBasePackages = {"pl.uam.movieSelector.spring"})
@EnableConfigurationProperties({OmdbProperties.class, FuzzyLogicProperties.class})
@EntityScan(basePackages = {"pl.uam.movieSelector.model"})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("Starting Spring boot application");
        SpringApplication.run(WebApplication.class, args);
    }

}
