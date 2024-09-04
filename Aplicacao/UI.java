package Aplicacao;

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
    public static void printarTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i< pecas.length; i++){
            System.out.print((8 - i)+ " ");
            for(int j=0; j< pecas.length; j++){
                printarPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }
    private static void printarPeca(PecaXadrez peca){
        if (peca == null){
            System.out.print("-");
        }
        else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
