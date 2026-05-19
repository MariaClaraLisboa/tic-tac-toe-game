package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Board {

    private static final Color COLOR = new Color(245, 132, 190);

    private int rows = 0;
    private int[] cells = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public void drawBoard(EngineFrame e) {

        e.drawLine(e.getScreenWidth() / 3.0, 0, e.getScreenWidth() / 3.0, e.getScreenHeight(), COLOR);
        e.drawLine(e.getScreenWidth() - e.getScreenWidth() / 3.0, 0, e.getScreenWidth() - e.getScreenWidth() / 3.0, e.getScreenHeight(), COLOR);
        e.drawLine(0, e.getScreenHeight() / 3.0, e.getScreenWidth(), e.getScreenHeight() / 3.0, COLOR);
        e.drawLine(0, e.getScreenHeight() - e.getScreenHeight() / 3.0, e.getScreenWidth(), e.getScreenHeight() - e.getScreenHeight() / 3.0, COLOR);

    }

    public boolean updateBoard(EngineFrame e){
        if(e.isKeyPressed(e.KEY_R)){
            cells = new int [] {
                0, 0, 0, 0, 0, 0, 0, 0, 0
            };
            rows = 0;
            return true;
        }
        return false;
    }

    public int[] getCells() {
        return cells;
    }

    public int getCell(int i) {
        return cells[i];
    }

    public void setCell(int i, int player) {
        cells[i] = player;
        rows++;
    }

    public int getRows() {
        return rows;
    }
}
