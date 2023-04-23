package io.GitHub.viniciusDias1001.Project.Moments.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Entity
@Table(name = "Foto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo",nullable = false)
    @NotEmpty
    private String titulo;

    @Column(name = "data",nullable = false)
    private LocalDate data;

    @Column(name = "localizacao",nullable = false)
    @NotEmpty
    private String localizacao;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;





}
