package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDao;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Inversão de Dependência (DIP)
        LivroDao dao = new LivroDAOSqlite();

        System.out.println("==================================");
        System.out.println("       SISTEMA BOOKSTORE");
        System.out.println("==================================");

        // 2. Cadastrando três livros
        Livro livro1 = new Livro(
            "Clean Code",
            "Robert C. Martin",
            89.90
        );

        Livro livro2 = new Livro(
            "Design Patterns",
            "Erich Gamma",
            120.50
        );

        Livro livro3 = new Livro(
            "Refactoring",
            "Martin Fowler",
            99.90
        );

        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        System.out.println("\n--- LIVROS CADASTRADOS ---");

        System.out.println("ID gerado: " + livro1.getId());
        System.out.println("ID gerado: " + livro2.getId());
        System.out.println("ID gerado: " + livro3.getId());

        // 3. Buscar livro existente (ID 2)
        System.out.println("\n--- CONSULTA POR ID ---");

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println(
                "Livro encontrado: " + livro
            ),
            () -> System.out.println(
                "Nenhum livro encontrado com esse ID."
            )
        );

        // 4. Buscar ID inexistente
        System.out.println("\n--- CONSULTA ID INEXISTENTE ---");

        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println(
                "Livro encontrado: " + livro
            ),
            () -> System.out.println(
                "Aviso: não existe livro cadastrado com ID 999."
            )
        );

        // 5. Listar todos os livros
        System.out.println("\n--- LISTAGEM COMPLETA ---");

        List<Livro> livros = dao.listarTodos();

        System.out.printf(
            "%-5s | %-25s | %-22s | %10s%n",
            "ID", "TÍTULO", "AUTOR", "PREÇO"
        );

        System.out.println(
            "--------------------------------------------------------------------------"
        );

        for (Livro livro : livros) {

            System.out.printf(
                "%-5d | %-25s | %-22s | R$ %8.2f%n",
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco()
            );
        }

        System.out.println("\n==================================");
        System.out.println("       TESTES FINALIZADOS");
        System.out.println("==================================");
    }
}