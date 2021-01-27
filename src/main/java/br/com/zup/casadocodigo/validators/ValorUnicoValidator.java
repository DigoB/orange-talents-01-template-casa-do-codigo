package br.com.zup.casadocodigo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return false;
    }

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
