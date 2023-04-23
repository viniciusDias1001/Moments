package io.GitHub.viniciusDias1001.Project.Moments.repository;

import io.GitHub.viniciusDias1001.Project.Moments.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
