public class NotaFiscal implements IDocumento {

    private String numero;
    private String dataEmissao;
    private String cliente;
    private double valorTotal;

    public NotaFiscal(String numero, String dataEmissao, String cliente, double valorTotal) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    @Override
    public void gerarPDF() {
        // Implementação para gerar o PDF da nota fiscal
        System.out.println("Gerando PDF da Nota Fiscal: " + numero);
        System.out.println("Data de Emissão: " + dataEmissao);
        System.out.println("Cliente: " + cliente);
        System.out.println("Valor Total: R$ " + valorTotal);
    }



}
