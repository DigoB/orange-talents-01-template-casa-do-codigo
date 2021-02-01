package br.com.zup.casadocodigo.paises;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    private String nomePais;

    public PaisForm() {}

    public PaisForm(@NotBlank String nome) {
        this.nomePais = nomePais;
    }

    public String getNome() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}
