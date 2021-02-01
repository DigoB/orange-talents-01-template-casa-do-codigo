package br.com.zup.casadocodigo.pagamento;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerficaCpfOuCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ComprasForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ComprasForm form = (ComprasForm) target;
        if (form.documentoValido()) {
            errors.rejectValue("Documento", null, "Documento precisaser CPF ou CNPJ.");
        }

    }
}
