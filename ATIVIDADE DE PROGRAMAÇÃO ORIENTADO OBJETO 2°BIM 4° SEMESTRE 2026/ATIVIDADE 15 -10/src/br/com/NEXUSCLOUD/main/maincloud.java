package br.com.NEXUSCLOUD.main;

import br.com.NEXUSCLOUD.exception.CapacidadeExcedidaException;
import br.com.NEXUSCLOUD.model.cloudmanager;
import br.com.NEXUSCLOUD.model.Cliente;
import br.com.NEXUSCLOUD.model.container;
import br.com.NEXUSCLOUD.model.servidor;

// Classe executável com o roteiro de testes do NexusCloud Manager. RA: 000000
public class maincloud {

    public static void main(String[] args) {

        // 1. Instancia o CloudManager. RA: 000000
        cloudmanager manager = new cloudmanager();

        // 2. Instancia 1 cliente. RA: 000000
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // 3. Instancia 1 servidor (nasce desligado): IP, RAM total 16.0 GB, R$ 5,50/h. RA: 000000
        servidor servidor = new servidor("192.168.0.1", 16.0, 5.50);

        // 4. Registra o cliente no banco e associa o servidor a ele. RA: 000000
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // 5. Instancia 2 containers diferentes. RA: 000000
        container c1 = new container("C-01", 10.0);
        container c2 = new container("C-02", 8.0);

        // 6. Teste de falha UNCHECKED: servidor desligado => ServidorOfflineException.
        //    Sem try-catch de propósito. Está COMENTADA para o programa prosseguir (descomente para ver o erro). RA: 000000
        // servidor.alocarContainer(c1);   // (a checked também exige tratamento: use "throws Exception" no main só para testar) RA: 000000

        // 7. Liga o servidor. RA: 000000
        servidor.ligar();

        // 8. Aloca o Container 1 com sucesso (a checked exige try-catch). RA: 000000
        try {
            servidor.alocarContainer(c1);
            System.out.println("Container " + c1.getId() + " alocado com sucesso.");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // 9. Teste de falha CHECKED: 10.0 + 8.0 = 18.0 > 16.0 => CapacidadeExcedidaException. RA: 000000
        try {
            servidor.alocarContainer(c2);
            System.out.println("Container " + c2.getId() + " alocado com sucesso.");
        } catch (CapacidadeExcedidaException e) {
            // Imprime o erro de forma elegante, sem derrubar a aplicação. RA: 000000
            System.out.println("Erro tratado: " + e.getMessage());
        }

        // 10. Imprime a fatura ativa do cliente (esperado: 5.50). RA: 000000
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
