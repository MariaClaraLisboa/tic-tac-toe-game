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
    // Depois colocar só um pra verificar vitória, nao precisa de dois

    public boolean verificarVitoriaDoX() {

        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == 1 && tabuleiro.getCelula(i + 1) == 1 && tabuleiro.getCelula(i + 2) == 1) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == 1 && tabuleiro.getCelula(i + 3) == 1 && tabuleiro.getCelula(i + 6) == 1) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == 1 && tabuleiro.getCelula(4) == 1 && tabuleiro.getCelula(8) == 1) {
            primeiraCelulaVencedora = 0;
            ultimaCelulaVencedora = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == 1 && tabuleiro.getCelula(4) == 1 && tabuleiro.getCelula(6) == 1) {
            primeiraCelulaVencedora = 2;
            ultimaCelulaVencedora = 6;
            return true;
        }

        return false;
    }

    public boolean verificarVitoriaDoO() {

        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == 2 && tabuleiro.getCelula(i + 1) == 2 && tabuleiro.getCelula(i + 2) == 2) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == 2 && tabuleiro.getCelula(i + 3) == 2 && tabuleiro.getCelula(i + 6) == 2) {
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == 2 && tabuleiro.getCelula(4) == 2 && tabuleiro.getCelula(8) == 2) {
            primeiraCelulaVencedora = 0;
            ultimaCelulaVencedora = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == 2 && tabuleiro.getCelula(4) == 2 && tabuleiro.getCelula(6) == 2) {
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
