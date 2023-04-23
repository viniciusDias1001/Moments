package io.GitHub.viniciusDias1001.Project.Moments.controller;


import io.GitHub.viniciusDias1001.Project.Moments.entities.EmailConfirmeLogin;
import io.GitHub.viniciusDias1001.Project.Moments.entities.Foto;
import io.GitHub.viniciusDias1001.Project.Moments.entities.User;
import io.GitHub.viniciusDias1001.Project.Moments.repository.UserRepository;
import io.GitHub.viniciusDias1001.Project.Moments.service.EmailService;
import io.GitHub.viniciusDias1001.Project.Moments.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {


    @Autowired
    private final UserService userService;

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final UserRepository userRepository;


    public UserController( UserService userService, EmailService emailService, UserRepository userRepository) {
        this.userService = userService;
        this. emailService = emailService;
        this.userRepository = userRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user){
        EmailConfirmeLogin emailConfirmeLogin = new EmailConfirmeLogin();
        emailService.sendEmail(emailConfirmeLogin, user);
        return userService.save(user);
    }


    @DeleteMapping("{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String email){
        userService.delete(email);
    }


    @GetMapping
    public List<Foto> find(User filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return userRepository.findAll(example);
    }

}
