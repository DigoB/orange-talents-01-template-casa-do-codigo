package br.com.zup.casadocodigo.detalheLivro;

import br.com.zup.casadocodigo.livros.DetalhesDeNovoLivroDto;
import br.com.zup.casadocodigo.livros.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DetalheLivroSiteController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<DetalhesDeNovoLivroDto> detalheLivro  (@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new DetalhesDeNovoLivroDto(livroRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro de id " + id + " não encontrado."))));
    }
}
