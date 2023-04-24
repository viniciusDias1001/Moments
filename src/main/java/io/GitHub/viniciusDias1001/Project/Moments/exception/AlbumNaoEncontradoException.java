package io.GitHub.viniciusDias1001.Project.Moments.exception;

public class AlbumNaoEncontradoException extends RuntimeException {
    public AlbumNaoEncontradoException(String s) {
        super("Album not Foud in DB");
    }
}
