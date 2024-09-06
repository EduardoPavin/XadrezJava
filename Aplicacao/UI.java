package Aplicacao;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import Xadrez.PosicaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static PosicaoXadrez lerPosicaoXadrez(Scanner scanner){
        try {
            String s = scanner.nextLine();
            char coluna = s.charAt(0);
            int linha = Integer.parseInt(s.substring(1));
            return new PosicaoXadrez(coluna, linha);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("Erro ao ler a posição, insira um valor válido");
        }
    }
    public static void printarPartida(PartidaXadrez partidaXadrez){
        printarTabuleiro(partidaXadrez.getPecas());
        System.out.println();
        System.out.println("Turno: "+ partidaXadrez.getTurno());
        System.out.println("Esperando o jogador "+partidaXadrez.getJogadorAtual()+" jogar!");
    }
    public static void printarTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i< pecas.length; i++){
            System.out.print((8 - i)+ " ");
            for(int j=0; j< pecas.length; j++){
                printarPeca(pecas[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    public static void printarTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis) {
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j], movimentosPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }


    private static void printarPeca(PecaXadrez peca, boolean fundo) {
        if (fundo) {
            System.out.print("o ");
        } else if (peca == null) {
            System.out.print("- ");
        } else {
            System.out.print(peca + " ");
        }
    }



}
