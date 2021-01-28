package br.com.zup.casadocodigo.livros;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.validators.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroForm {

    @NotNull
    @ValorUnico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotNull
    @Size(max = 500)
    private String resumo;
    @NotNull
    private String sumario;
    @NotNull
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numPaginas;
    @NotNull
    @ValorUnico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    private String categoria;
    @NotNull
    private String autor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    //Setter criado pois o jackson não consegue desserializar o formato em json, no momento não conheço outra alternativa
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}