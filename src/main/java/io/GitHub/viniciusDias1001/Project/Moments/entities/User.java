package io.GitHub.viniciusDias1001.Project.Moments.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "nome")
    @NotEmpty
    private String nome;

    @Column(name = "email", length = 200)
    @NotEmpty(message = "Informe o email, atributo não pode ser Vazio/Nulo")
    @Email(message = "Informe um Email Válido.")
    private String email;

    @Column(name = "senha", length = 200)
    @NotEmpty(message = "Campo senha não pode ser Vázio")
    private String senha;

}
