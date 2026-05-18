package template;

public class PosicaoPeca {

    private Peca peca;
    private Tabuleiro tabuleiro;
    private int x;
    private int y;

    public PosicaoPeca(int x, int y, Tabuleiro tabuleiro, Peca peca) {
        this.x = x;
        this.y = y;
        this.tabuleiro = tabuleiro;
        this.peca = peca;
    }

    public void setPosicao(int tamanhoTela) {

        int tamanhoCelula = tamanhoTela / 3;
        int jogador;

        if (peca.getJogador() == 1) {
            jogador = 1;
        } else {
            jogador = 2;
        }

        if (x < tamanhoCelula) { //Mapeando primeira coluna
            if (y < tamanhoCelula && tabuleiro.getCelula(0) == 0) {
                tabuleiro.setCelulas(0, jogador);
            } else if (y > tamanhoCelula && y < tamanhoCelula * 2 && tabuleiro.getCelula(3) == 0) {
                tabuleiro.setCelulas(3, jogador);
            } else if (y > tamanhoCelula * 2 && y < tamanhoCelula * 3 && tabuleiro.getCelula(6) == 0) {
                tabuleiro.setCelulas(6, jogador);
            }
        }

        else if (x < tamanhoCelula * 2) { //Mapeando segunda coluna
            if (y < tamanhoCelula && tabuleiro.getCelula(1) == 0) {
                tabuleiro.setCelulas(1, jogador);
            } else if (y > tamanhoCelula && y < tamanhoCelula * 2 && tabuleiro.getCelula(4) == 0) {
                tabuleiro.setCelulas(4, jogador);
            } else if (y > tamanhoCelula * 2 && y < tamanhoCelula * 3 && tabuleiro.getCelula(7) == 0) {
                tabuleiro.setCelulas(7, jogador);
            }
        }

        else if (x < tamanhoCelula * 3) { //Mapeando terceira coluna
            if (y < tamanhoCelula && tabuleiro.getCelula(2) == 0) {
                tabuleiro.setCelulas(2, jogador);
            } else if (y > tamanhoCelula && y < tamanhoCelula * 2 && tabuleiro.getCelula(5) == 0) {
                tabuleiro.setCelulas(5, jogador);
            } else if (y > tamanhoCelula * 2 && y < tamanhoCelula * 3 && tabuleiro.getCelula(8) == 0) {
                tabuleiro.setCelulas(8, jogador);
            }
        }
    }
}
