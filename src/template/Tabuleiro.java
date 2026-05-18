package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Tabuleiro {

    private static final Color COR = new Color(245, 132, 190);

    private int rodadas = 0;
    private int[] celulas = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public void desenharTabuleiro(EngineFrame e) {
        //coloca um for aqui depois talvez, mas desencessário sinceramente
        e.drawLine(e.getScreenWidth() / 3.0, 0, e.getScreenWidth() / 3.0, e.getScreenHeight(), COR);
        e.drawLine(e.getScreenWidth() - e.getScreenWidth() / 3.0, 0, e.getScreenWidth() - e.getScreenWidth() / 3.0, e.getScreenHeight(), COR);
        e.drawLine(0, e.getScreenHeight() / 3.0, e.getScreenWidth(), e.getScreenHeight() / 3.0, COR);
        e.drawLine(0, e.getScreenHeight() - e.getScreenHeight() / 3.0, e.getScreenWidth(), e.getScreenHeight() - e.getScreenHeight() / 3.0, COR);

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
