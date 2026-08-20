package br.com.techcorp.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleDeAcesso {

    // Histórico da catraca.
    // ArrayList permite elementos repetidos
    // e mantém a ordem de inserção.
    private List<Funcionario> historicoCatraca;

    // Funcionários atualmente autorizados na sala segura.
    // HashSet não permite elementos duplicados
    // e utiliza equals/hashCode para verificar duplicidade.
    private Set<Funcionario> autorizadosSalaSegura;

    // Construtor
    public ControleDeAcesso() {
        historicoCatraca = new ArrayList<>();
        autorizadosSalaSegura = new HashSet<>();
    }

    // Registra uma passagem na catraca
    public void registrarPassagem(Funcionario f) {
        historicoCatraca.add(f);

        System.out.println(
                "Passagem registrada na catraca: "
                + f.getmatricula()
                + " - "
                + f.getnome()
        );
    }

    // Concede acesso à sala segura
    public void concederAcessoSala(Funcionario f) {

        boolean adicionou = autorizadosSalaSegura.add(f);

        if (adicionou) {

            System.out.println(
                    "Acesso liberado para a Sala Segura"
            );

        } else {

            System.out.println(
                    "Aviso: Matrícula já registrada na sala. Acesso não permitido."
            );
        }
    }

    // Getters
    public List<Funcionario> getHistoricoCatraca() {
        return historicoCatraca;
    }

    public Set<Funcionario> getAutorizadosSalaSegura() {
        return autorizadosSalaSegura;
    }
}