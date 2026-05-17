package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Tabuleiro {

    private int[] celulas = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private static final Color cor = new Color(245, 132, 190);
    private int rodadas = 0;

    public void desenharTabuleiro(EngineFrame e) {

        e.drawLine(e.getScreenWidth() / 3, 0, e.getScreenWidth() / 3, e.getScreenHeight(), cor);
        e.drawLine(e.getScreenWidth() - e.getScreenWidth() / 3, 0, e.getScreenWidth() - e.getScreenWidth() / 3, e.getScreenHeight(), cor);
        e.drawLine(0, e.getScreenHeight() / 3, e.getScreenWidth(), e.getScreenHeight() / 3, cor);
        e.drawLine(0, e.getScreenHeight() - e.getScreenHeight() / 3, e.getScreenWidth(), e.getScreenHeight() - e.getScreenHeight() / 3, cor);

    }

    public boolean updateTabuleiro(EngineFrame e, double delta){
        if(e.isKeyPressed(e.KEY_R)){
            celulas = new int [] {
                0, 0, 0, 0, 0, 0, 0, 0, 0
            };
            rodadas = 0;
            return true;
        }
        return false;
    }

    public void setCelulas(int i, int jogador) {
        celulas[i] = jogador;
        rodadas++;
    }

    public int getRodadas() {
        return rodadas;
    }

    public int getCelula(int i) {
        return celulas[i];
    }

    public int[] getCelulas() {
        return celulas;
    }
}
