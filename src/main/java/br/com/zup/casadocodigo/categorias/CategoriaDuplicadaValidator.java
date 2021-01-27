package br.com.zup.casadocodigo.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovaCategoriaDto cadastrar = (NovaCategoriaDto) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(cadastrar.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Categoria já cadastrada!");
        }

    }
}
