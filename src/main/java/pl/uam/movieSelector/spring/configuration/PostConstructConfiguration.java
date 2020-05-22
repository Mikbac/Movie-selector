package pl.uam.movieSelector.spring.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import pl.uam.movieSelector.spring.service.FuzzyLogicService;

import javax.annotation.Resource;

@Log4j2
@Configuration
public class PostConstructConfiguration {

    @Resource
    private FuzzyLogicService fuzzyLogicService;

    @EventListener(ApplicationReadyEvent.class)
    public void initOMDBData() {
        log.info("Initializing data from OMDB!");
        fuzzyLogicService.LoadOMDBMovie();
    }

}
