public class Fake { 

     public static void main(String[] args) {

        Decodificador cesar = DecodificadorCesar(7);
        Decodificador reverso = DecodificadorBase64();
        Decodificador base64 = DecodificadorBase64();

        String mensagem = "Mpsayl v jhuhs CLYTLSOV kh pthnlt ybpkv.itw. Ptwhy = Wylav, Why = Iyhujv";

        System.out.println("Mensagem original:");
        System.out.println(mensagem);

        System.out.println("\nCésar:");
        System.out.println(((Object) cesar).decodificar(mensagem));

        System.out.println("\nReverso:");
        System.out.println(((Object) reverso).decodificar(mensagem));

        // Não execute Base64 diretamente nessa mensagem,
        // pois ela não é Base64.

        FiltroImagem filtro = FiltroVermelhoMagico();

        filtro.aplicarFiltro(
                "src/ruido.bmp",
                "src/resultado.bmp"
        );
    }

     private static Decodificador DecodificadorBase64() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DecodificadorBase64'");
    }

     private static Decodificador DecodificadorCesar(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DecodificadorCesar'");
     }
}
