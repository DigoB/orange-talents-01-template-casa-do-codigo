package br.com.zup.casadocodigo.validators;

import br.com.zup.casadocodigo.paises.Estado;
import br.com.zup.casadocodigo.paises.EstadoForm;
import br.com.zup.casadocodigo.paises.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EstadoDuplicadoValidator implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EstadoForm form = (EstadoForm) target;

        Optional<Estado> possivelEstado = estadoRepository.findByNome(form.getNome());
        if (possivelEstado.isPresent()) {
            errors.rejectValue("nome", null, "Estado já cadastrado");
        }
    }
}
