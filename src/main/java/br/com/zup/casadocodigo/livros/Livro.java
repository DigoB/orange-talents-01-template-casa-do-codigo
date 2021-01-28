package br.com.zup.casadocodigo.livros;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.categorias.Categoria;
import br.com.zup.casadocodigo.categorias.DetalhesDeNovaCategoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String titulo;
    private @NotBlank @Size(max = 500) String resumo;
    private @NotBlank String sumario;
    private @NotNull @Min(20) BigDecimal preco;
    private @NotNull @Min(100) Integer numPaginas;
    private @NotBlank String isbn;
    @NotNull
    private @Future LocalDate dataPublicacao;
    @ManyToOne
    private @NotNull @Valid Autor autor;
    @ManyToOne
    @Valid
    private @NotNull Categoria categoria;

    public Livro(Long id, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
                 @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numPaginas, @NotBlank String isbn,
                 @Future @NotNull LocalDate dataPublicacao, @NotBlank @Valid Autor autor, @NotBlank @Valid Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    @Deprecated
    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String isbn, LocalDate dataPublicacao, Categoria category, Autor author) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        categoria = category;
        autor = author;
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

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public DetalhesDeNovaCategoria getCategoria() {
        return categoria;
    }

    // Setter criado, pois o jackson não é capaz de desserializar o json com a data parametro pelo construtor
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numPaginas=" + numPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
