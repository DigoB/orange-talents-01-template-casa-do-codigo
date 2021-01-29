package br.com.zup.casadocodigo.livros;


import br.com.zup.casadocodigo.autores.DetalhesDeNovoAutor;
import br.com.zup.casadocodigo.categorias.DetalhesDeNovaCategoria;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDeNovoLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String dataPublicacao;
    private String isbn;
    private DetalhesDeNovaCategoria categoria;
    private DetalhesDeNovoAutor autor;

    public DetalhesDeNovoLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.isbn = livro.getIsbn();
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

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalhesDeNovaCategoria getCategoria() {
        return categoria;
    }

    public DetalhesDeNovoAutor getAutor() {
        return autor;
    }

    public static List<DetalhesDeNovoLivroDto> converter(List<Livro> livros) {
        return livros.stream().map(DetalhesDeNovoLivroDto::new).collect(Collectors.toList());
    }

}