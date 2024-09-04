package Xadrez;

import MesaDeJogo.Peca;
import MesaDeJogo.Posicao;
import MesaDeJogo.Tabuleiro;
import Xadrez.pecas.Rei;
import Xadrez.pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        FormacaoOriginal();
    }
    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }
    private void ColarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    }

    private void FormacaoOriginal(){
        ColarNovaPeca('b',6, new Torre(tabuleiro, Cor.BRANCO));
        ColarNovaPeca('e',8, new Rei(tabuleiro, Cor.PRETO));
        ColarNovaPeca('e',1, new Rei(tabuleiro, Cor.BRANCO));
    }
}

