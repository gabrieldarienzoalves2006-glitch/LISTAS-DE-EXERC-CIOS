import java.util.Base64;

public class DecodificadorBase64 {

        public class DecodificadorBase64 implements Decodificador{
             @Override
    public String decodificar(String texto) {
        byte[] dados = Base64.getDecoder().decode(texto);
        return new String(dados);
    }
        }
}
