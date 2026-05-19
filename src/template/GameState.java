package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;
import br.com.davidbuzatto.jsge.math.Vector2;

import java.awt.*;

public class GameState {

    private Board board;
    private int [] winnerCells = new int[3];

    public GameState (Board board) {
        this.board = board;
    }

    public boolean victory (int player){
        for (int i = 0; i < 9; i += 3) {
            if (board.getCell(i) == player && board.getCell(i + 1) == player && board.getCell(i + 2) == player) {
                winnerCells[0] = i;
                winnerCells[1] = i+1;
                winnerCells[2] = i+2;
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board.getCell(i) == player && board.getCell(i + 3) == player && board.getCell(i + 6) == player) {
                winnerCells[0] = i;
                winnerCells[1] = i+3;
                winnerCells[2] = i+6;
                return true;
            }
        }

        if (board.getCell(0) == player && board.getCell(4) == player && board.getCell(8) == player) {
            winnerCells[0] = 0;
            winnerCells[1] = 4;
            winnerCells[2] = 8;
            return true;
        }

        if (board.getCell(2) == player && board.getCell(4) == player && board.getCell(6) == player) {
            winnerCells[0] = 2;
            winnerCells[1] = 4;
            winnerCells[2] = 6;
            return true;
        }

        return false;
    }

    public void drawWinnerCells(EngineFrame e){

        CellPositions cellPositions = new CellPositions(1, e);
        Color winnerCellsColor = new Color(247, 25, 142);

        double cellSize = e.getScreenWidth()/3.0;

        for (int i = 0; i < 3; i++) {

            Vector2 pos = cellPositions.getCellPositionVector(winnerCells[i],1);
            double posX = pos.x;
            double posY = pos.y;

            e.fillRectangle(posX - cellSize/2, posY - cellSize/2, cellSize, cellSize, ColorUtils.fade(winnerCellsColor, 0.25));

        }
    }
}
