package io.GitHub.viniciusDias1001.Project.Moments.entities;


import io.GitHub.viniciusDias1001.Project.Moments.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMAIL_USUARIO_SUCCESS")
public class EmailConfirmeLogin {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailId")
    private Long emailId;

    @Column(name = "dataa")
    private LocalDateTime sendDateEmail;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEmail statusEmail;


}
