package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Symbol {

    private Board board;
    private CellPositions cellPosition;

    private int x;
    private int y;

    public Symbol(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public void setSymbolPosition(EngineFrame e, int player) {

        int cellSize = e.getScreenWidth() / 3;

        if (x < cellSize) { // Defining first column
            if (y < cellSize && board.getCell(0) == 0) {    // Checking if cell is empty, if not, then will not be set
                board.setCell(0, player);                   // Cell 0
            } else if (y > cellSize && y < cellSize * 2 && board.getCell(3) == 0) {
                board.setCell(3, player);                   // Cell 3
            } else if (y > cellSize * 2 && y < cellSize * 3 && board.getCell(6) == 0) {
                board.setCell(6, player);                   // Cell 6
            }
        }

        else if (x < cellSize * 2) { // Defining second column
            if (y < cellSize && board.getCell(1) == 0) {
                board.setCell(1, player);                   // Cell 1
            } else if (y > cellSize && y < cellSize * 2 && board.getCell(4) == 0) {
                board.setCell(4, player);                   // Cell 4
            } else if (y > cellSize * 2 && y < cellSize * 3 && board.getCell(7) == 0) {
                board.setCell(7, player);                   // Cell 7
            }
        }

        else if (x < cellSize * 3) { // Defining third column
            if (y < cellSize && board.getCell(2) == 0) {
                board.setCell(2, player);                   // Cell 2
            } else if (y > cellSize && y < cellSize * 2 && board.getCell(5) == 0) {
                board.setCell(5, player);                   // Cell 5
            } else if (y > cellSize * 2 && y < cellSize * 3 && board.getCell(8) == 0) {
                board.setCell(8, player);                   // Cell 8
            }
        }
    }

    public void drawSymbol(EngineFrame e, int cell, String symbolText, int symbolSize, Color color) {

        cellPosition = new CellPositions(symbolSize, e);
        double textSize = e.measureText(symbolText, symbolSize);;

        e.drawText(symbolText, cellPosition.getCellPositionVector(cell, textSize), symbolSize, color);

    }
}
