package io.GitHub.viniciusDias1001.Project.Moments.controller;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import io.GitHub.viniciusDias1001.Project.Moments.entities.Foto;
import io.GitHub.viniciusDias1001.Project.Moments.exception.AlbumNaoEncontradoException;
import io.GitHub.viniciusDias1001.Project.Moments.repository.AlbumRepository;
import io.GitHub.viniciusDias1001.Project.Moments.repository.FotoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {

    private final FotoRepository fotoRepository;

    private final AlbumRepository albumRepository;



    public FotoController(FotoRepository fotoRepository, AlbumRepository albumRepository) {
        this.fotoRepository = fotoRepository;
        this.albumRepository = albumRepository;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Foto save(@RequestBody @Valid Foto foto){
        foto.setData(LocalDate.now());
        Integer albumId = foto.getAlbum().getId();
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new AlbumNaoEncontradoException("Álbum não encontrado"));
        foto.setAlbum(album);
        return fotoRepository.save(foto);
    }



    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        fotoRepository.findById(id).map(foto -> {
            fotoRepository.delete(foto);
            return foto;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Foto not Foud in DB"));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Foto getByid(@PathVariable Integer id){
        return fotoRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Foto not Foud in DB"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody @Valid Foto foto ){
       fotoRepository
                .findById(id)
                .map( fotoExistente -> {
                    foto.setId(fotoExistente.getId());
                    fotoRepository.save(foto);
                    return fotoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Foto not Foud in DB") );
    }

    @GetMapping
    public List<Foto> find(Foto filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return fotoRepository.findAll(example);
    }




}
