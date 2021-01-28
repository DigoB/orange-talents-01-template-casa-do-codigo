package br.com.zup.casadocodigo.categorias;

public class DetalhesDeNovaCategoria {

    private String nome;

    public DetalhesDeNovaCategoria(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public DetalhesDeNovaCategoria() {
    }

    public String getNome() {
        return nome;
    }
}
