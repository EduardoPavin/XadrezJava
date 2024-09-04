package Aplicacao;

import MesaDeJogo.Posicao;
import MesaDeJogo.Tabuleiro;
import Xadrez.PartidaXadrez;

public class Main {
    public static void main(String[] args) {
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        UI.printarTabuleiro(partidaXadrez.getPecas());
    }
}
