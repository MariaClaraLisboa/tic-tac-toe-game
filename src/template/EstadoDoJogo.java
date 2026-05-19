package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class EstadoDoJogo {

    private Tabuleiro tabuleiro;
    private int primeiraCelulaVencedora;
    private int ultimaCelulaVencedora;

    public EstadoDoJogo(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean verificarVitoria(int jogador){
        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == jogador && tabuleiro.getCelula(i + 1) == jogador && tabuleiro.getCelula(i + 2) == jogador) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == jogador && tabuleiro.getCelula(i + 3) == jogador && tabuleiro.getCelula(i + 6) == jogador) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == jogador && tabuleiro.getCelula(4) == jogador && tabuleiro.getCelula(8) == jogador) {
            primeiraCelulaVencedora = 0;
            ultimaCelulaVencedora = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == jogador && tabuleiro.getCelula(4) == jogador && tabuleiro.getCelula(6) == jogador) {
            primeiraCelulaVencedora = 2;
            ultimaCelulaVencedora = 6;
            return true;
        }

        return false;
    }

    public void desenharLinhaDaVitoria(EngineFrame e){

        CentroCelulas centroCelulas = new CentroCelulas(1, e);

        e.drawLine(
                centroCelulas.getVetorPosicao(primeiraCelulaVencedora,1),
                centroCelulas.getVetorPosicao(ultimaCelulaVencedora, 1),
                Color.WHITE
                );
    }
}
