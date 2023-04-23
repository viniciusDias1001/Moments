package io.GitHub.viniciusDias1001.Project.Moments.service;

import io.GitHub.viniciusDias1001.Project.Moments.entities.EmailConfirmeLogin;
import io.GitHub.viniciusDias1001.Project.Moments.entities.User;
import io.GitHub.viniciusDias1001.Project.Moments.enums.StatusEmail;
import io.GitHub.viniciusDias1001.Project.Moments.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.Base64;

@Service

public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;
    public EmailService(EmailRepository emailRepository) throws IOException {
        this.emailRepository = emailRepository;
    }

    @Transactional
    public EmailConfirmeLogin sendEmail(EmailConfirmeLogin emailModel, User user) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            emailModel.setStatusEmail(StatusEmail.SENT);
            message.setFrom("pedrorochadias1001@gmail.com");
            message.setTo(user.getEmail());
            message.setSubject("Bem Vindo ao Moments");
            message.setText("Bem vindo  " + user.getEmail() + "   Espero que Você possa Guardar não só no seu coração  aqueles  Lindos Momentos mas sim aqui no Moments " + PhotoinString());
            emailSender.send(message);


        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }


    public String PhotoinString() throws IOException {
        File file = new File("Project Moments-Back\\pedro.jpg");
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        String base64String = Base64.getEncoder().encodeToString(imageBytes);
        return base64String;

    }


}
