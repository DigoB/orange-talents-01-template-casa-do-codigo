package br.com.zup.casadocodigo.categorias;

public class DetalhesDeNovaCategoria {

    private String nome;

    public DetalhesDeNovaCategoria(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
