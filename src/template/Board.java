package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Board {

    private static final Color COLOR = new Color(245, 132, 190);

    private int boardSize;
    private int rows = 0;
    private int[] cells = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    public Board (int boardSize){
        this.boardSize = boardSize;
    }

    public void drawBoard(EngineFrame e) {

        e.drawLine(boardSize / 3.0, 0, boardSize / 3.0, boardSize, COLOR);
        e.drawLine(boardSize - boardSize / 3.0, 0, boardSize - boardSize / 3.0, boardSize, COLOR);
        e.drawLine(0, boardSize / 3.0, boardSize, boardSize / 3.0, COLOR);
        e.drawLine(0, boardSize - boardSize / 3.0, boardSize, boardSize - boardSize / 3.0, COLOR);

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

    public int getBoardSize() {
        return boardSize;
    }
}
