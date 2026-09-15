package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;

public class MainTeste {

    public class MainTeste {
    public static void main(String[] args) {
        // 1. Instanciando a nova CalculadoraFrete
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        // 2. Bloco try-catch para controle de fluxo e tratamento de erros
        try {
            System.out.println("--- Iniciando testes de frete válidos ---");

            // 3. Executando os 3 testes válidos injetando as estratégias
            double valorSedex = calculadora.processarFrete(valorPedido, new FreteSedex());
            System.out.println("Valor do frete SEDEX (10%): R$ " + valorSedex);

            double valorPac = calculadora.processarFrete(valorPedido, new FretePac());
            System.out.println("Valor do frete PAC (5%): R$ " + valorPac);

            double valorMotoboy = calculadora.processarFrete(valorPedido, new FreteMotoboy());
            System.out.println("Valor do frete Motoboy (Fixo): R$ " + valorMotoboy);

            System.out.println("\n--- Forçando o cenário de erro ---");

            // 4. Forçando o erro ao injetar 'null' na estratégia
            calculadora.processarFrete(valorPedido, null);

            // Esta linha nunca será executada devido à exceção lançada acima
            System.out.println("Este texto não deve aparecer no console.");

        } catch (TipoFreteInvalidoException e) {
            // 5. Capturando a exceção customizada e exibindo apenas a mensagem amigável
            System.out.println("Sucesso no tratamento! O sistema não capotou.");
            System.out.println("Mensagem capturada: " + e.getMessage());
        }

        System.out.println("\n--- O programa continuou executando normalmente até o fim ---");
    }
}

}
