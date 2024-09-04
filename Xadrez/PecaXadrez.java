package Xadrez;

import MesaDeJogo.Peca;
import MesaDeJogo.Tabuleiro;

public class PecaXadrez extends Peca {
    public Cor getCor() {
        return cor;
    }

    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }
}
