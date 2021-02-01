package br.com.zup.casadocodigo.paises;

import br.com.zup.casadocodigo.validators.PaisDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private PaisDuplicadoValidator paisDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(paisDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<Pais> novoPais(@RequestBody @Valid PaisForm form, UriComponentsBuilder uriBuilder) {

        Pais novoPais = new Pais(form.getNome());

        paisRepository.save(novoPais);

        URI path = uriBuilder.path("/paises/{id}").buildAndExpand(novoPais).toUri();
        return ResponseEntity.ok().body(novoPais);

    }
}
