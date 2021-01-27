package br.com.zup.casadocodigo.autores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class CadastraAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<DetalhesDeNovoAutor> cadastraAutor(@RequestBody @Valid AutorForm form) {

        Autor novoAutor = form.paraAutor();
        autorRepository.save(novoAutor);

        return ResponseEntity.ok().body(new DetalhesDeNovoAutor(novoAutor));
    }
}
