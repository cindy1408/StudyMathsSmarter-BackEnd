package com.StudyMathsSmarter.StudyMathsSmarter.security;

public class Authentication {
    private String message;

    public Authentication(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
