package io.GitHub.viniciusDias1001.Project.Moments.exception;

public class FotoNotFoudException extends RuntimeException{
    public FotoNotFoudException(String message) {
        super("Foto not Find in DB");
    }
}
