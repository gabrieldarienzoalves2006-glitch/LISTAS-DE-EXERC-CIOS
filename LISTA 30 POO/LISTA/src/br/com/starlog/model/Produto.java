
package br.com.starlog.model;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    // Construtor de negócio
    public Produto(String nome, double preco, int estoque) {
        validarNome(nome);
        validarPreco(preco);
        validarEstoque(estoque);

        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // Construtor de persistência
    public Produto(Long id, String nome, double preco, int estoque) {
        this(nome, preco, estoque);
        this.id = id;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException(
                "O nome deve possuir pelo menos 3 caracteres."
            );
        }
    }

    private void validarPreco(double preco) {
        if (!Double.isFinite(preco) || preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço deve ser maior que zero."
            );
        }
    }

    private void validarEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException(
                "O estoque não pode ser negativo."
            );
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validarPreco(preco);
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validarEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %-5d | Nome: %-25s | Preço: R$ %8.2f | Estoque: %d",
            id, nome, preco, estoque
        );
    }
}