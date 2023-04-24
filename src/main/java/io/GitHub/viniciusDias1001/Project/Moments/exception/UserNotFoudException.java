package io.GitHub.viniciusDias1001.Project.Moments.exception;

public class UserNotFoudException extends RuntimeException{
    public UserNotFoudException(String message) {
        super("User not Foud in DB");
    }
}
