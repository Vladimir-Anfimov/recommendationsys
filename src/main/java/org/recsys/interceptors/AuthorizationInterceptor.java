package org.recsys.interceptors;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.recsys.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String SESSION_COOKIE_NAME = "token";
    private final SessionRepository sessionRepository;

    public AuthorizationInterceptor(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    /**
     * Checks if the user is authorized to access the requested resource
     * by extracting the session cookie from the request and checking if it exists in the database.
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try
        {
            Stream<Cookie> cookiesStream = Arrays.stream(request.getCookies());
            String sessionCookie = cookiesStream.filter(cookie -> cookie.getName().equals(SESSION_COOKIE_NAME))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);

            if (sessionCookie == null || !sessionRepository.existsByToken(sessionCookie)) {
                response.sendRedirect("/signin");
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            response.sendRedirect("/signin");
            return false;
        }

        return true;
    }
}
