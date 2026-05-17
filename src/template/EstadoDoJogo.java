package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class EstadoDoJogo {

    private Tabuleiro tabuleiro;
    private int primeiraCelulaVencedora;
    private int ultimaCelulaVencedora;
    CentroCelulas centroCelulas;

    public EstadoDoJogo(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean verificarVitoriaDoX() {

        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == 1 && tabuleiro.getCelula(i + 1) == 1 && tabuleiro.getCelula(i + 2) == 1) {
                System.out.println("vitoria do X!");
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == 1 && tabuleiro.getCelula(i + 3) == 1 && tabuleiro.getCelula(i + 6) == 1) {
                System.out.println("vitoria do X!");
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == 1 && tabuleiro.getCelula(4) == 1 && tabuleiro.getCelula(8) == 1) {
            System.out.println("vitoria do X!");
            primeiraCelulaVencedora = 0;
            ultimaCelulaVencedora = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == 1 && tabuleiro.getCelula(4) == 1 && tabuleiro.getCelula(6) == 1) {
            System.out.println("vitoria do X!");
            primeiraCelulaVencedora = 2;
            ultimaCelulaVencedora = 6;
            return true;
        }

        return false;
    }

    public boolean verificarVitoriaDoO() {

        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == 2 && tabuleiro.getCelula(i + 1) == 2 && tabuleiro.getCelula(i + 2) == 2) {
                System.out.println("vitoria do O!");
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == 2 && tabuleiro.getCelula(i + 3) == 2 && tabuleiro.getCelula(i + 6) == 2) {
                System.out.println("vitoria do O!");
                primeiraCelulaVencedora = i;
                ultimaCelulaVencedora = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == 2 && tabuleiro.getCelula(4) == 2 && tabuleiro.getCelula(8) == 2) {
            System.out.println("vitoria do O!");
            primeiraCelulaVencedora = 0;
            ultimaCelulaVencedora = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == 2 && tabuleiro.getCelula(4) == 2 && tabuleiro.getCelula(6) == 2) {
            System.out.println("vitoria do O!");
            primeiraCelulaVencedora = 2;
            ultimaCelulaVencedora = 6;
            return true;
        }

        return false;

    }

    public void desenharLinhaDaVitoria(EngineFrame e){
        centroCelulas = new CentroCelulas(1, e);

        e.drawLine(
                centroCelulas.getVetorPosicao(primeiraCelulaVencedora,1),
                centroCelulas.getVetorPosicao(ultimaCelulaVencedora, 1),
                Color.BLACK
                );
    }
}
