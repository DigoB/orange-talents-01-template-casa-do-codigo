package br.com.zup.casadocodigo.categorias;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDto {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria paraCategoria() {
        return new Categoria(nome);
    }
}
