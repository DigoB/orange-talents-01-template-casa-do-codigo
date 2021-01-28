package br.com.zup.casadocodigo.livros;


import javax.validation.Valid;

import br.com.zup.casadocodigo.autores.AutorRepository;
import br.com.zup.casadocodigo.categorias.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<DetalhesDeNovoLivroDto> lista() {
        List<Livro> livros = livroRepository.findAll();
        return DetalhesDeNovoLivroDto.converter(livros);
    }

    @PostMapping
    public ResponseEntity<DetalhesDeNovoLivroDto> cadastraLivro(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuilder) {
        Livro livro = new Livro(form.getTitulo(), form.getResumo(), form.getSumario(), form.getPreco(), form.getNumPaginas(),
                form.getIsbn(), form.getDataPublicacao(),
                categoriaRepository.findByNome(form.getCategoria())
                        .orElseThrow(() -> new IllegalStateException(exceptionMsg(form.getCategoria(), "Categoria"))),
                autorRepository.findByNome(form.getAutor())
                        .orElseThrow(() -> new IllegalStateException(exceptionMsg(form.getCategoria(), "Autor"))));
        livroRepository.save(livro);

        URI path = uriBuilder.path("/categorias/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.ok().body(new DetalhesDeNovoLivroDto(livro));
    }

    private String exceptionMsg(String nome, String elemento) {
        return ("Não existe " + elemento + " " + nome + " registrado.");
    }
}
