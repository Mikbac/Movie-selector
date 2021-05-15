package pl.uam.movieSelector.spring.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pl.uam.movieSelector.constants.AttributeConstants.ModelAttributes.AllPages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by MikBac on 01.07.2020
 */

@Log4j2
public class CountryInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][{}]", () -> request);
        if (modelAndView != null) {
            modelAndView.addObject(AllPages.LANGUAGE, Locale.getDefault());
        }
    }

}
