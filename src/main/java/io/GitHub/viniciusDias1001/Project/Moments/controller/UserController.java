package io.GitHub.viniciusDias1001.Project.Moments.controller;


import io.GitHub.viniciusDias1001.Project.Moments.entities.EmailConfirmeLogin;
import io.GitHub.viniciusDias1001.Project.Moments.entities.User;
import io.GitHub.viniciusDias1001.Project.Moments.service.EmailService;
import io.GitHub.viniciusDias1001.Project.Moments.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {


    @Autowired
    private final UserService userService;

    @Autowired
    private final EmailService emailService;


    public UserController( UserService userService, EmailService emailService) {
        this.userService = userService;
        this. emailService = emailService;
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
}
