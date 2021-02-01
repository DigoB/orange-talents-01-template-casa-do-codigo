package br.com.zup.casadocodigo.paises;

import br.com.zup.casadocodigo.validators.EstadoDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;


@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoDuplicadoValidator estadoDuplicadoValidator;
    @Autowired
    private PaisRepository paisRepository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<Estado> novoEstado(@RequestBody @Valid EstadoForm form) {
        Estado novoEstado = new Estado(form.getNome(), paisRepository.findByNome(form.getNomePais()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "País não encontrado")));


        estadoRepository.save(novoEstado);

        return ResponseEntity.ok().body(novoEstado);

    }

}
