package Xadrez;

import MesaDeJogo.ExcecaoMesa;
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
    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem){
        Posicao posicao = posicaoOrigem.toPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }
    private Peca fazerMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca capturada = tabuleiro.removerPeca(destino);

        if (p != null) {
            tabuleiro.colocarPeca(p, destino);
        } else {
            throw new ExcecaoMesa("Nenhuma peça na posição de origem para mover");
        }

        return capturada;
    }

    public PecaXadrez fazerMovimentoPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = fazerMovimento(origem, destino);
        return (PecaXadrez)pecaCapturada;
    }
    private void validarPosicaoOrigem(Posicao posicao){
        if (!tabuleiro.temPeca(posicao)){
            throw new ExcecaoXadrez("Não existe peça na posição de origem");
        }
        if (!tabuleiro.peca(posicao).existemMovimentosPossiveis()){
            throw new ExcecaoXadrez("Não existe movimentos possíveis para a peça escolhida");

        }
    }
    private void validarPosicaoDestino(Posicao origem, Posicao destino){
        if (!tabuleiro.peca(origem).movimentosPossiveis(destino)){
            throw new ExcecaoXadrez("A peça escolhida não pode ir para a posição de destino");
        }
    }
    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    }

    private void FormacaoOriginal(){
        colocarNovaPeca('b',6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e',8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e',1, new Rei(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('b',2, new Rei(tabuleiro, Cor.BRANCO));
    }
}

