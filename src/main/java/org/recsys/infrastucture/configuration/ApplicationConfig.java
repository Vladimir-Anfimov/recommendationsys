package org.recsys.infrastucture.configuration;

import org.recsys.interceptors.AuthorizationInterceptor;
import org.recsys.repositories.SessionRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    private final SessionRepository sessionRepository;

    public ApplicationConfig(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor(sessionRepository))
                .addPathPatterns("/**")
                .excludePathPatterns("/signin", "/signup");
    }
}
