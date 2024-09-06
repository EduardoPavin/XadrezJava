package Aplicacao;


import Xadrez.ExcecaoXadrez;
import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while (true) {
            try {
                UI.limparTela();
                UI.printarPartida(partidaXadrez);
                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(scanner);
                boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
                UI.limparTela();
                UI.printarTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(scanner);

                PecaXadrez pecaCapturada = partidaXadrez.fazerMovimentoPeca(origem, destino);
            }
            catch (ExcecaoXadrez | InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
