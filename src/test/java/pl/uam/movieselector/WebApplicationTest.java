package pl.uam.movieselector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.uam.movieselector.spring.controller.MainPageController;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by MikBac on 2021
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTest {

    @Resource
    private MainPageController mainPageController;

    @Test
    public void contextLoads() {
        assertThat(mainPageController).isNotNull();
    }

}