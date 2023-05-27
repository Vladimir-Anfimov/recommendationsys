package org.recsys.exceptions;

public class UserSigninException extends Exception {
    private static final String DEFAULT_MESSAGE = "User or password incorrect.";
    public UserSigninException() {
        super(DEFAULT_MESSAGE);
    }
}
