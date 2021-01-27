package br.com.zup.casadocodigo.categorias;

import br.com.zup.casadocodigo.validators.ValorUnico;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    @Column(unique = true, nullable = false)
    @ValorUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria paraCategoria() {
        return new Categoria(nome);
    }

}
