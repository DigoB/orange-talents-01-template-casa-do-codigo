package br.com.zup.casadocodigo.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<DetalhesDeNovaCategoria> cadastraCategoria(@RequestBody @Valid CategoriaForm form,
                                                                     UriComponentsBuilder uriBuilder) {

        Categoria novaCategoria = form.paraCategoria();

        categoriaRepository.save(novaCategoria);

        URI path = uriBuilder.path("/categorias/{id}").buildAndExpand(novaCategoria.getId()).toUri();
        return ResponseEntity.ok().body(new DetalhesDeNovaCategoria(novaCategoria));

    }
}
