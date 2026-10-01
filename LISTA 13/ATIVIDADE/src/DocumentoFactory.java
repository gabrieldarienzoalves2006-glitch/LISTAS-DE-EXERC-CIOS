public class DocumentoFactory {

public static IDocumento criarDocumento(String tipo){
    if (tipo == null){
        throw new IllegalArgumentException("Tipo de documento não pode ser nulo");
    }

    switch (tipo.toUpperCase()){
        case "NF":
            return  NotaFiscal;
        case "RECIBO":
            return Recibo;
        default:
            throw new IllegalArgumentException("Tipo de documento inválido: " + tipo);
    }
}

}
