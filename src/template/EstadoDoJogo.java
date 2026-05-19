package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;
import br.com.davidbuzatto.jsge.math.Vector2;

import java.awt.*;

public class EstadoDoJogo {

    private Tabuleiro tabuleiro;
    private int []celulasVencedoras = new int[3];
    private int primeiraCelulaVencedora;
    private int meioCelulaVencedora;
    private int ultimaCelulaVencedora;

    public EstadoDoJogo(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean verificarVitoria(int jogador){
        for (int i = 0; i < 9; i += 3) {
            if (tabuleiro.getCelula(i) == jogador && tabuleiro.getCelula(i + 1) == jogador && tabuleiro.getCelula(i + 2) == jogador) {
                celulasVencedoras[0] = i;
                celulasVencedoras[1] = i+1;
                celulasVencedoras[2] = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCelula(i) == jogador && tabuleiro.getCelula(i + 3) == jogador && tabuleiro.getCelula(i + 6) == jogador) {
                celulasVencedoras[0] = i;
                celulasVencedoras[1] = i+3;
                celulasVencedoras[2] = i+6;
                return true;
            }
        }

        if (tabuleiro.getCelula(0) == jogador && tabuleiro.getCelula(4) == jogador && tabuleiro.getCelula(8) == jogador) {
            celulasVencedoras[0] = 0;
            celulasVencedoras[1] = 4;
            celulasVencedoras[2] = 8;
            return true;
        }

        if (tabuleiro.getCelula(2) == jogador && tabuleiro.getCelula(4) == jogador && tabuleiro.getCelula(6) == jogador) {
            celulasVencedoras[0] = 2;
            celulasVencedoras[1] = 4;
            celulasVencedoras[2] = 6;
            return true;
        }

        return false;
    }

    public void desenharLinhaDaVitoria(EngineFrame e, double tamanhoCelula){

        CentroCelulas centroCelulas = new CentroCelulas(1, e);

        for (int i = 0; i < 3; i++) {
            Vector2 pos = centroCelulas.getVetorPosicao(celulasVencedoras[i],1);
            double posX = pos.x;
            double posY = pos.y;
            e.fillRectangle(posX - tamanhoCelula/2, posY - tamanhoCelula/2, tamanhoCelula, tamanhoCelula, ColorUtils.fade(new Color(247, 25, 142), 0.25));

        }
    }
}
