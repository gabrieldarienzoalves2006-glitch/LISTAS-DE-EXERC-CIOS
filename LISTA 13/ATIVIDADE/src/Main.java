public class Main {
    public static void main(String[] args) {
        
        GerenciarConfiguracao gen1 = GerenciarConfiguracao.getInstancia();
        System.out.println("API Key da primeira instância: " + gen1.getApiKey());

        
        GerenciarConfiguracao gen2 = GerenciarConfiguracao.getInstancia();
        if (gen1 == gen2) {
            System.out.println("Sucesso: Ambas as instâncias apontam para o mesmo endereço de memória (Singleton).");
        } else {
            System.out.println("Erro: As instâncias são diferentes.");
        }

       
        System.out.println("\n--- Testando a Fábrica de Documentos ---");
        IDocumento notaFiscal = DocumentoFactory.criarDocumento("NF");
        notaFiscal.gerarPDF();

        
        try {
            System.out.println("\nTentando criar um documento inválido (BOLETO)...");
            IDocumento boleto = DocumentoFactory.criarDocumento("BOLETO");
            boleto.gerarPDF();
        } catch (IllegalArgumentException e) {
           
            System.out.println("Erro amigável: Não foi possível processar a requisição. Motivo: " + e.getMessage());
        }
    }
}