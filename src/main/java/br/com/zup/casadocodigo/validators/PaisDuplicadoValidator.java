package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.paises.Pais;
import br.com.zup.casadocodigo.paises.PaisForm;
import br.com.zup.casadocodigo.paises.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PaisDuplicadoValidator implements Validator {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return PaisForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        PaisForm form = (PaisForm) target;

        Optional<Pais> possivelPais = paisRepository.findByNome(form.getNome());

        if (possivelPais.isPresent()) {
            errors.rejectValue("nome", null, "Pais já cadastrado");
        }
    }
}
