package br.com.meusistema.main;

import br.com.meusistema.model.Carro;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");

        //criando o objeto (Construindo carro 1)
        Carro meuCarro = new Carro();
        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");

        //Chamando o método (Comportamento)
        meuCarro.Buzinar();
        
        //criando o objeto (Construindo carro 2)
        Carro meuCarro2 = new Carro();
        meuCarro2.setModelo("Gol");
        meuCarro2.setCor("Preto");
        meuCarro2.setVelocidade(-200);

         //Chamando o método (Comportamento)
        meuCarro2.Buzinar();
    }
}

