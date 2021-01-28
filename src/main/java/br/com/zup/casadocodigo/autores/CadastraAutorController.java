package br.com.zup.casadocodigo.autores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class CadastraAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<DetalhesDeNovoAutor> cadastraAutor(@RequestBody @Valid AutorForm form,
                                                             UriComponentsBuilder uriBuilder) {

        Autor novoAutor = form.paraAutor();
                ;
        autorRepository.save(novoAutor);

        URI path = uriBuilder.path("/autores/{id}").buildAndExpand(novoAutor.getId()).toUri();
        return ResponseEntity.ok().body(new DetalhesDeNovoAutor(novoAutor));
    }
}
