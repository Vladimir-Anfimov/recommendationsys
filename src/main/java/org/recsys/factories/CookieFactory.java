package org.recsys.factories;

import jakarta.servlet.http.Cookie;

public class CookieFactory {
    private static final String NAME = "token";
    private static final int MAX_AGE_IN_SECONDS = 3600;
    private static final String PATH = "/";
    private static final boolean SECURE = true;

    /**
     * Creates a session cookie with the given token.
     * @param token
     * @return
     */
    public static Cookie createSessionCookie(String token) {
        Cookie cookie = new Cookie(NAME, token);
        cookie.setMaxAge(MAX_AGE_IN_SECONDS);
        cookie.setPath(PATH);
        cookie.setSecure(SECURE);
        return cookie;
    }

}
