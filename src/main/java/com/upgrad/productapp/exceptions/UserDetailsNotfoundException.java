package com.upgrad.productapp.exceptions;

public class UserDetailsNotfoundException extends Exception {

    public UserDetailsNotfoundException() {
    }

    public UserDetailsNotfoundException(String message) {
        super(message);
    }

    public UserDetailsNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDetailsNotfoundException(Throwable cause) {
        super(cause);
    }

    public UserDetailsNotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
