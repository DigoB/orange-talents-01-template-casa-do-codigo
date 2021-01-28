package br.com.zup.casadocodigo.livros;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.autores.DetalhesDeNovoAutor;
import br.com.zup.casadocodigo.categorias.Categoria;
import br.com.zup.casadocodigo.categorias.DetalhesDeNovaCategoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesDeNovoLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private LocalDate dataPublicacao;
    private DetalhesDeNovaCategoria categoria;
    private DetalhesDeNovoAutor autor;

    public DetalhesDeNovoLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria();
        this.autor = new DetalhesDeNovoAutor(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalhesDeNovaCategoria getCategoria() {
        return categoria;
    }

    public DetalhesDeNovoAutor getAutor() {
        return autor;
    }
}