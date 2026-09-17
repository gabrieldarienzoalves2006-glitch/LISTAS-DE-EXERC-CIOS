package br.com.meusistema.model;

public class Carro {
    private String modelo;
    private String cor;
    private int velocidade;

    public void Buzinar(){
        System.out.println("O " + modelo + " " + cor + " fez: BIIII BIIII");

        public int velocidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        if (velocidade < 0) {
            System.out.println("Velocidade não pode ser negativa. Definindo para 0.");
            this.velocidade = 0;
        } else {
            this.velocidade = velocidade;
        }
    }
}
