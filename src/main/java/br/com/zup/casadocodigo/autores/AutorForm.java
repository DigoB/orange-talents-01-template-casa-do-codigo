package br.com.zup.casadocodigo.autores;

import br.com.zup.casadocodigo.validators.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @ValorUnico(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorForm(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor paraAutor() {
        return new Autor(nome,email,descricao);
    }
}
