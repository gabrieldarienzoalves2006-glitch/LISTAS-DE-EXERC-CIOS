import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FiltroVermelhoMagico implements FiltroImagem {

    public void aplicarFiltro(String caminhoEntrada, String caminhoSaida) {

        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoEntrada));

            int largura = imagem.getWidth();
            int altura = imagem.getHeight();

            BufferedImage resultado =
                    new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < altura; y++) {

                for (int x = 0; x < largura; x++) {

                    int rgb = imagem.getRGB(x, y);

                    int vermelho = (rgb >> 16) & 0xFF;

                    if (vermelho % 2 == 0) {
                        // PAR = BRANCO
                        resultado.setRGB(x, y, 0xFFFFFF);
                    } else {
                        // ÍMPAR = PRETO
                        resultado.setRGB(x, y, 0x000000);
                    }
                }
            }

            ImageIO.write(
                    resultado,
                    "bmp",
                    new File(caminhoSaida)
            );

            System.out.println("Filtro aplicado com sucesso!");
            System.out.println("Imagem salva em: " + caminhoSaida);

        } catch (Exception e) {
            System.out.println("Erro ao processar imagem.");
            e.printStackTrace();
        }
    }
}
