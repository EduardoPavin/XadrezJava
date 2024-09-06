package Xadrez.pecas;

import MesaDeJogo.Peca;
import MesaDeJogo.Posicao;
import MesaDeJogo.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Rei extends PecaXadrez {
    public Rei(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }
    @Override
    public String toString(){
        return (getCor() == Cor.BRANCO) ? "♚" : "♔";
    }

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }


    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0,0);
        //cima
        p.setValores(posicao.getLinha()-1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //baixo
        p.setValores(posicao.getLinha()+1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna()-1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //direita
        p.setValores(posicao.getLinha(), posicao.getColuna()+1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //NO
        p.setValores(posicao.getLinha()-1, posicao.getColuna()-1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //NE
        p.setValores(posicao.getLinha()-1, posicao.getColuna()+1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //SO
        p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        //SE
        p.setValores(posicao.getLinha()+1, posicao.getColuna()+1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }



        return mat;
    }
}
