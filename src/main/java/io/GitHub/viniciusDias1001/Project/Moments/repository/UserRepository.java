package io.GitHub.viniciusDias1001.Project.Moments.repository;

import io.GitHub.viniciusDias1001.Project.Moments.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User>findByEmail(String email);
}
