package io.GitHub.viniciusDias1001.Project.Moments.controller;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import io.GitHub.viniciusDias1001.Project.Moments.entities.Foto;
import io.GitHub.viniciusDias1001.Project.Moments.repository.AlbumRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/album")
@CrossOrigin(origins = "*")
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


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        albumRepository.findById(id).map(album -> {
            albumRepository.delete(album);
            return album;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Album not Foud in DB"));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getByid(@PathVariable Integer id){
        return albumRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Album not Foud in DB"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid Album album ){
        albumRepository
                .findById(id)
                .map( albumExistente -> {
                    album.setId(albumExistente.getId());
                    album.setDataCriacao(LocalDate.now());
                    albumRepository.save(album);
                    return albumExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Album not Foud in DB") );
    }


    @GetMapping
    public List<Album> find(Album filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return albumRepository.findAll(example);
    }

}
