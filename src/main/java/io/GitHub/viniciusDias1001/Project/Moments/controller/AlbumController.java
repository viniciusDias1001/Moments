package io.GitHub.viniciusDias1001.Project.Moments.controller;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import io.GitHub.viniciusDias1001.Project.Moments.repository.AlbumRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/album")
public class AlbumController {

    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album save (@RequestBody @Valid Album album){
        album.setDataCriacao(LocalDate.now());

        return albumRepository.save(album);
    }
}
