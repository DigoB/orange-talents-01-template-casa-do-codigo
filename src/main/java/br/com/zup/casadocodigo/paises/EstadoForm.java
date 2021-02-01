package br.com.zup.casadocodigo.paises;

import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    private String nomeEstado;
    @NotBlank
    private String nomePais;

    public EstadoForm() {}

    public EstadoForm(String nomeEstado, String nomePais) {
        this.nomeEstado = nomeEstado;
        this.nomePais = nomePais;
    }

    public String getNome() {
        return nomeEstado;
    }

    public String getNomePais() {
        return nomePais;
    }
}
