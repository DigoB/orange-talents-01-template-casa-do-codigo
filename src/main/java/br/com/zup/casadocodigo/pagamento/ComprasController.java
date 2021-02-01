package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.paises.Estado;
import br.com.zup.casadocodigo.paises.EstadoRepository;
import br.com.zup.casadocodigo.paises.Pais;
import br.com.zup.casadocodigo.paises.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class ComprasController {

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerficaCpfOuCnpjValidator());
    }

    @PostMapping
    public ResponseEntity<?> criaCompra(@RequestBody @Valid ComprasForm form) {

        Pais pais = paisRepository.findById(form.getIdPais()).orElseThrow(() -> new IllegalStateException("Pais não encontrado"));
        Estado estado = estadoRepository.findById(form.getIdEstado()).orElseThrow(() -> new IllegalStateException("Estado não encontrado"));
        if (estado.getPais() != pais) {
            throw new IllegalArgumentException("O estado não faz parte do pais");
        }


        return ResponseEntity.ok().build();

    }



}
