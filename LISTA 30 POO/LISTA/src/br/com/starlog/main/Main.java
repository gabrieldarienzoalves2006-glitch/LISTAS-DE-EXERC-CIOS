
package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDao;
import br.com.starlog.dao.ProdutoDaosqlite;
import br.com.starlog.model.Produto;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProdutoDao dao = new ProdutoDaosqlite();

        System.out.println("==========================================");
        System.out.println("       SISTEMA DE ESTOQUE STARLOG");
        System.out.println("==========================================");

        // 1. CREATE
        System.out.println("\n[1] CADASTRANDO PRODUTOS");

        Produto teclado = new Produto(
            "Teclado Mecânico RGB", 259.90, 10
        );

        Produto mousepad = new Produto(
            "Mousepad Speed XL", 79.90, 20
        );

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.println("Teclado cadastrado! ID: " + teclado.getId());
        System.out.println("Mousepad cadastrado! ID: " + mousepad.getId());

        // 2. READ
        System.out.println("\n[2] LISTAGEM DE PRODUTOS");

        exibirProdutos(dao.listarTodos());

        // 3. UPDATE
        System.out.println("\n[3] ATUALIZANDO TECLADO");

        teclado.setEstoque(15);
        teclado.setPreco(289.90);

        boolean atualizado = dao.atualizar(teclado);

        if (atualizado) {
            System.out.println("Produto atualizado com sucesso!");

            dao.buscarPorId(teclado.getId())
                .ifPresent(System.out::println);

        } else {
            System.out.println("Produto não encontrado para atualização.");
        }

        // 4. DELETE
        System.out.println("\n[4] EXCLUINDO PRODUTOS");

        boolean excluido = dao.excluir(mousepad.getId());

        if (excluido) {
            System.out.println("Mousepad excluído com sucesso!");
        } else {
            System.out.println("Mousepad não encontrado.");
        }

        // Teste com ID inexistente
        boolean inexistente = dao.excluir(888L);

        if (inexistente) {
            System.out.println("Produto 888 excluído.");
        } else {
            System.out.println(
                "ID 888 não encontrado. Nenhum registro foi excluído."
            );
        }

        // 5. ESTADO FINAL
        System.out.println("\n[5] ESTADO FINAL DO ESTOQUE");

        List<Produto> produtos = dao.listarTodos();

        exibirProdutos(produtos);

        System.out.println("\nTotal de produtos restantes: " + produtos.size());

        if (produtos.size() == 1) {
            System.out.println("TESTE CONCLUÍDO COM SUCESSO!");
        } else {
            System.out.println("ATENÇÃO: quantidade diferente da esperada.");
        }
    }

    private static void exibirProdutos(List<Produto> produtos) {

        System.out.printf(
            "%-5s | %-25s | %-12s | %-8s%n",
            "ID", "NOME", "PREÇO", "ESTOQUE"
        );

        System.out.println(
            "---------------------------------------------------------------"
        );

        for (Produto p : produtos) {
            System.out.printf(
                "%-5d | %-25s | R$ %-9.2f | %-8d%n",
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getEstoque()
            );
        }
    }
}
