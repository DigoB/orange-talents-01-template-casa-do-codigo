package br.com.zup.casadocodigo.autores;

import java.time.LocalDateTime;

public class DetalhesDeNovoAutor {
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao;

    public DetalhesDeNovoAutor(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getCriadoEm();
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
