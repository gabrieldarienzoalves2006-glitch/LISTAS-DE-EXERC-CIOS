package br.com.nexustech;

public class Matchmaker {

    public void encontrarSala(ModoJogo, boolean JogadorBanido) throws BanidoException {
        if (JogadorBanido) {
            throw new BanidoException("O jogador está banido e não pode entrar na sala.");
        }
        // Lógica para encontrar uma sala com base no ModoJogo
    }
}
