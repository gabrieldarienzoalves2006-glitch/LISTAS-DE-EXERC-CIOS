package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {

    public static void main(String[] args) {

        // Instancia o sistema de controle de acesso
        ControleDeAcesso controle = new ControleDeAcesso();

        // Primeiro funcionário
        Funcionario f1 = new Funcionario(
                "T-001",
                "Alice",
                "Analista"
        );

        // Segundo funcionário.
        // Possui a mesma matrícula do f1,
        // mas é outro objeto na memória.
        Funcionario f2 = new Funcionario(
                "T-001",
                "Alice Duplicada",
                "Analista"
        );

        System.out.println("======================================");
        System.out.println(" TESTE DA CATRACA");
        System.out.println("======================================");

        // Registra f1 na catraca
        controle.registrarPassagem(f1);

        // Registra f2 na catraca
        // Deve funcionar normalmente,
        // pois a catraca aceita histórico de entradas repetidas.
        controle.registrarPassagem(f2);

        System.out.println();

        System.out.println("======================================");
        System.out.println(" TESTE DA SALA SEGURA");
        System.out.println("======================================");

        // Primeiro acesso
        controle.concederAcessoSala(f1);

        // Segundo acesso com a mesma matrícula
        // Deve ser bloqueado pelo HashSet.
        controle.concederAcessoSala(f2);

        System.out.println();

        System.out.println("======================================");
        System.out.println(" RESULTADO FINAL");
        System.out.println("======================================");

        System.out.println(
                "Total de registros na catraca: "
                + controle.getHistoricoCatraca().size()
        );

        System.out.println(
                "Total de funcionários na Sala Segura: "
                + controle.getAutorizadosSalaSegura().size()
        );
    }
}