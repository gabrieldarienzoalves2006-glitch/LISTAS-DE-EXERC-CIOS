public class DecodificadorCesar {

        public DecodificadorCesar(int i) {
        //TODO Auto-generated constructor stub
    }

        public class DecodificadorCesar implements Decodificador {

    private int chave;

    public DecodificadorCesar(int chave) {
        this.chave = chave;
    }

    @Override
    public String decodificar(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {

            if (c >= 'A' && c <= 'Z') {
                char novo = (char) ((c - 'A' - chave + 26) % 26 + 'A');
                resultado.append(novo);

            } else if (c >= 'a' && c <= 'z') {
                char novo = (char) ((c - 'a' - chave + 26) % 26 + 'a');
                resultado.append(novo);

            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
}

}
