package io.GitHub.viniciusDias1001.Project.Moments.repository;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Album> encontrarPorAlbum(@Param("nome") String nome );
}
