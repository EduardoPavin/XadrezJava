package MesaDeJogo;

public class Tabuleiro {

    private int linhas;
    private int colunas;

    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1){
            throw new ExcecaoMesa("Erro ao criar tabuleiro: necessário ao menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linhas, int colunas){
        if (!posicaoExiste(linhas, colunas)){
            throw new ExcecaoMesa("Posição fora da mesa");
        }
        return pecas[linhas][colunas];
    }
    public Peca peca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new ExcecaoMesa("Posição fora da mesa");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    public void colocarPeca(Peca peca, Posicao posicao){
        if (temPeca(posicao)){
            throw new ExcecaoMesa("Já tem uma peça na posição "+posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >=0 && coluna < colunas;
    }
    public boolean posicaoExiste(Posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }
    public boolean temPeca(Posicao posicao){
        if (!posicaoExiste(posicao)){
            throw new ExcecaoMesa("Posição não está no tabuleiro");
        }
        return peca(posicao) != null;
    }
}
