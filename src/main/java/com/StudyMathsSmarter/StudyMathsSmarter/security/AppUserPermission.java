package com.StudyMathsSmarter.StudyMathsSmarter.security;

public enum AppUserPermission {
    USER_READ("student:read"),
    USER_WRITE("student:write"),
    QUESTION_READ("question:read"),
    QUESTION_WRITE("question:write"),
    QUIZ_READ("quiz:read"),
    QUIZ_WRITE("quiz:write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
