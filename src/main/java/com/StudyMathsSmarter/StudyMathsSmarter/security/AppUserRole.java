package com.StudyMathsSmarter.StudyMathsSmarter.security;

import java.util.HashSet;
import java.util.Set;

import static com.StudyMathsSmarter.StudyMathsSmarter.security.AppUserPermission.*;

public enum AppUserRole {
    STUDENT(Set.of(USER_READ, QUESTION_READ, QUIZ_READ, QUIZ_WRITE)),
    ADMIN(Set.of(USER_READ, USER_WRITE, QUESTION_READ, QUESTION_WRITE, QUIZ_READ, QUIZ_WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
