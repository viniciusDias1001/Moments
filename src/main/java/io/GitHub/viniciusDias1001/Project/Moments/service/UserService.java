package io.GitHub.viniciusDias1001.Project.Moments.service;

import io.GitHub.viniciusDias1001.Project.Moments.entities.User;
import io.GitHub.viniciusDias1001.Project.Moments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    public User save (User user){

        return userRepository.save(user);
    }


    @Transactional
    public void delete (String email){
        userRepository.findByEmail(email).map(userFind -> {
            userRepository.delete(userFind);
            return userFind;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not Find in DB"));
    }









}
