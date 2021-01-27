package br.com.zup.casadocodigo.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<DetalhesDeNovaCategoria> cadastraCategoria(@RequestBody @Valid CategoriaForm form) {

        Categoria novaCategoria = form.paraCategoria();

        categoriaRepository.save(novaCategoria);

        return ResponseEntity.ok().body(new DetalhesDeNovaCategoria(novaCategoria));

    }
}
