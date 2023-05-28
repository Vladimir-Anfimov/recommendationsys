package org.recsys.exceptions;

public class SessionCookieException extends Exception {
    private static final String DEFAULT_MESSAGE = "Session cookie is not valid";
    public SessionCookieException() {
        super(DEFAULT_MESSAGE);
    }
}
