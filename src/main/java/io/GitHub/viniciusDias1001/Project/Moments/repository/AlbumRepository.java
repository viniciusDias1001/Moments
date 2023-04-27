package io.GitHub.viniciusDias1001.Project.Moments.repository;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

    List<Album> findAllByChave( Integer chave );
}
