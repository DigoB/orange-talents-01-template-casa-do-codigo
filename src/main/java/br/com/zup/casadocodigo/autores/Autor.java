package br.com.zup.casadocodigo.autores;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @NotEmpty @Column(nullable = false)
    private String nome;
    @NotBlank @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Size(max = 400) @Column(nullable = false) @NotBlank
    private String descricao;
    private LocalDateTime criadoEm =LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(Long id, @NotBlank @NotEmpty String nome, @NotBlank @NotEmpty @Email String email, @Size(max = 400) String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

}