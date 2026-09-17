package br.com.technexus.main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Instancia a Loja
        Loja loja = new Loja();

        // Cadastra os 5 produtos variados
        loja.cadastrar(new Produto("The Witcher", "GAMES", 150.0));
        loja.cadastrar(new Produto("FIFA", "GAMES", 200.0));
        loja.cadastrar(new Produto("Java for Dummies", "LIVROS", 100.0));
        loja.cadastrar(new Produto("Clean Code", "LIVROS", 80.0));
        loja.cadastrar(new Produto("Mouse", "HARDWARE", 50.0));

        // 1. Imprime os produtos da categoria "GAMES"
        System.out.println("--- PRATELEIRA DE GAMES ---");
        List<Produto> games = loja.buscarPorCategoria("GAMES");
        games.forEach(System.out.println);

        // 2. Imprime o patrimônio total do estoque
        System.out.println("\n--- PATRIMÔNIO TOTAL DO ESTOQUE ---");
        double patrimonioTotal = loja.calcularPatrimonioTotal();
        System.out.println("Valor total em estoque: R$ " + patrimonioTotal);

        // 3. Imprime o valor total apenas dos "LIVROS"
        System.out.println("\n--- TOTAL APENAS EM LIVROS ---");
        double totalLivros = loja.calcularTotalPorCategoria("LIVROS");
        System.out.println("Valor total da prateleira de livros: R$ " + totalLivros);
    }

}