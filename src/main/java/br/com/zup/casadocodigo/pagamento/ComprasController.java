package br.com.zup.casadocodigo.pagamento;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class ComprasController {

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerficaCpfOuCnpjValidator());
    }

    @PostMapping
    public String criaCompra(@RequestBody @Valid ComprasForm form) {

        return form.toString();

    }



}
