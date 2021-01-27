package br.com.zup.casadocodigo.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaDuplicadaValidator categoriaDuplicadaValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaDuplicadaValidator);
    }

    @PostMapping
    public String cadastraCategoria(@RequestBody @Valid NovaCategoriaDto novaCategoria) {

        Categoria cat = new Categoria(novaCategoria.getNome());
        System.out.println(novaCategoria);

        categoriaRepository.save(cat);
        return cat.toString();

    }
}
